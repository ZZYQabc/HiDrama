package com.personal.zzyq.dao;

import com.personal.zzyq.bean.Drama;
import com.personal.zzyq.bean.DramaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DramaMapper {
    long countByExample(DramaExample example);

    int deleteByExample(DramaExample example);

    int deleteByPrimaryKey(Integer dramaId);

    int insert(Drama record);

    int insertSelective(Drama record);

    List<Drama> selectByExample(DramaExample example);

    Drama selectByPrimaryKey(Integer dramaId);
    
    List<Drama> selectByExampleWithType(DramaExample example);

    Drama selectByPrimaryKeyWithType(Integer dramaId);

    int updateByExampleSelective(@Param("record") Drama record, @Param("example") DramaExample example);

    int updateByExample(@Param("record") Drama record, @Param("example") DramaExample example);

    int updateByPrimaryKeySelective(Drama record);

    int updateByPrimaryKey(Drama record);
}