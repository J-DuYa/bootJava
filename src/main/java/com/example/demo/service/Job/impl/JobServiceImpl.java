package com.example.demo.service.Job.impl;

import com.example.demo.mapper.JobMapper;
import com.example.demo.service.Job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Override
    public List<Map<Object, String>> queryList() {
        return null;
    }
}
