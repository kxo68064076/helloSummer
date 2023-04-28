package com.capricorn.summer.service;

import com.github.pagehelper.PageInfo;

public interface IFundService {
    PageInfo<Object> findAllFund(int pageSize, int pageNum);
}
