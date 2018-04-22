package com.taotao.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	
	@Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;

	@Override
	public List<EasyUITreeNode> getContentCategoryList(long parentId) {
		List<TbContentCategory> list = tbContentCategoryMapper.selectContentCategory(parentId);
		List<EasyUITreeNode> result = new ArrayList<>();
		for(TbContentCategory tbContentCategory : list){
			EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
			easyUITreeNode.setId(tbContentCategory.getId());
			easyUITreeNode.setText(tbContentCategory.getName());
			easyUITreeNode.setState(tbContentCategory.getIsParent()?"closed":"open");
			result.add(easyUITreeNode);
		}
		return result;
	}
	
	@Override
	public TaotaoResult addContentCategory(long parentId, String name) {
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setParentId(parentId);
		contentCategory.setName(name);
		//状态。可选值：1（正常），2（删除）
		contentCategory.setStatus(1);
		contentCategory.setSortOrder(1);
		contentCategory.setIsParent(false);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		tbContentCategoryMapper.insert(contentCategory);
		//判断父节点的状态
		TbContentCategory parent = tbContentCategoryMapper.selectByPrimaryKey(parentId);
		//如果父节点是叶子节点则应该改为父节点
		if(!parent.getIsParent()){
			parent.setIsParent(true);
			//更新父节点
			tbContentCategoryMapper.updateByPrimaryKey(contentCategory);
		}
		
		return TaotaoResult.ok(contentCategory);
	}

	@Override
	public void changeContentCategory(long id, String name) {
		TbContentCategory tbContentCategory = new TbContentCategory();
		tbContentCategory.setId(id);
		tbContentCategory.setName(name);
		//tbContentCategory.setUpdated(new Date());
		tbContentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
		
		
	}
	
	/**
	 * 删除节点
	 */
	@Override
	public void delContentCategory(long id) {
		TbContentCategory tbContentCategory = tbContentCategoryMapper.selectByPrimaryKey(id);
		//判断是否是父节点,如果是则用递归的方式删除
		if(tbContentCategory.getIsParent()){
			List<TbContentCategory> list = tbContentCategoryMapper.selectContentCategory(tbContentCategory.getId());
			for(TbContentCategory tb :list){
				delContentCategory(tb.getId());
			}
		}
		//如果不是则直接删除
		tbContentCategoryMapper.delContentCategoryByPrimaryKey(id);
		
	}

	

}
