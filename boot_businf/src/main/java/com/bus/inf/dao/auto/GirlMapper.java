package com.bus.inf.dao.auto;

import com.bus.inf.entity.auto.Girl;
import com.bus.inf.entity.auto.GirlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GirlMapper {
    int countByExample(GirlExample example);

    int deleteByExample(GirlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Girl record);

    int insertSelective(Girl record);

    List<Girl> selectByExample(GirlExample example);

    Girl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Girl record, @Param("example") GirlExample example);

    int updateByExample(@Param("record") Girl record, @Param("example") GirlExample example);

    int updateByPrimaryKeySelective(Girl record);

    int updateByPrimaryKey(Girl record);
}