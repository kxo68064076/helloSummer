package com.capricorn.summer.service;

import java.util.List;
import java.util.Map;

public interface IBecomingRichService {
    List<Map<String,Object>> findAllFundDetail();

    void fundQueryValue(Map<String,Object> param);
}
