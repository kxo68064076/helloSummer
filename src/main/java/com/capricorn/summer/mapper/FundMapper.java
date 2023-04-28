package com.capricorn.summer.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FundMapper {
    List<Object> findAllFund();
}
