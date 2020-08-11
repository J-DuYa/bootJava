package com.example.demo.controller;

import com.example.demo.service.Job.JobService;
import com.example.demo.util.Result;
import com.example.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    // 查询任务列表
    @GetMapping("/list")
    public Result<Object> getJobList() {
        // 获取Job List
        List<Map<Object, String>> resultMap = new ArrayList<Map<Object, String>>();
        Map<Object, String> map = new HashMap<Object, String>();
        map.put("data", null);
        resultMap.add(map);
        return ResultUtil.success(resultMap);
    }
}
