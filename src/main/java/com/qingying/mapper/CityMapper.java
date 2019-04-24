package com.qingying.mapper;

import com.qingying.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.jboss.logging.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface CityMapper {
    List<Map> queryList();

}
