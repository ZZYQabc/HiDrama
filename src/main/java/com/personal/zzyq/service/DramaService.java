package com.personal.zzyq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.zzyq.bean.Drama;
import com.personal.zzyq.bean.DramaExample;
import com.personal.zzyq.bean.DramaExample.Criteria;
import com.personal.zzyq.dao.DramaMapper;

@Service
public class DramaService {
	
	@Autowired
	DramaMapper dramaMapper;
	
	//查询所有剧集
	public List<Drama> getAll() {
		// TODO Auto-generated method stub
		return dramaMapper.selectByExampleWithType(null);
	}
	
	//剧集保存
	public void saveDra(Drama drama) {
		// TODO Auto-generated method stub
		dramaMapper.insertSelective(drama);
		
	}
	
	//检验剧集是否重复
	//true代表可用
	public boolean checkUser(String draName) {
		// TODO Auto-generated method stub
		DramaExample example = new DramaExample();
		Criteria criteria = example.createCriteria();
		criteria.andDramaNameEqualTo(draName);
		long count = dramaMapper.countByExample(example);
		return count == 0;
	}

	//按照剧集id查剧集
	public Drama getDra(Integer id) {
		
		// TODO Auto-generated method stub
		Drama drama = dramaMapper.selectByPrimaryKey(id);
		return drama;
	}

	//剧集更新
	public void updateDra(Drama drama) {
		// TODO Auto-generated method stub
		dramaMapper.updateByPrimaryKeySelective(drama);
		
	}

	//员工删除
	public void deleteDra(Integer id) {
		// TODO Auto-generated method stub
		dramaMapper.deleteByPrimaryKey(id);
		
	}

	public void deleteBatch(List<Integer> ids) {
		// TODO Auto-generated method stub
		DramaExample example = new DramaExample();
		Criteria criteria = example.createCriteria();
		//delete from xxx where dra_id in(1,2,3)
		criteria.andDramaIdIn(ids);
		dramaMapper.deleteByExample(example);
	}

	

}
