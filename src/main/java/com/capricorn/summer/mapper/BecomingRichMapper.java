package com.capricorn.summer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BecomingRichMapper {

    List<Map<String,Object>> findAllFundCode();

    int handle(@Param("data") Map<String,Object> data);

    int delAll();

    List<Map<String,Object>> findAllFundDetail();

    void fundQueryValue(Map<String,Object> param);
}
