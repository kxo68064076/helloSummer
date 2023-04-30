package com.capricorn.summer.service.impl;

import com.capricorn.summer.mapper.BecomingRichMapper;
import com.capricorn.summer.service.IBecomingRichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BecomingRichServiceImpl implements IBecomingRichService {

    @Autowired
    private BecomingRichMapper mapper;

    @Override
    public List<Map<String, Object>> findAllFundDetail() {
        return mapper.findAllFundDetail();
    }
}
