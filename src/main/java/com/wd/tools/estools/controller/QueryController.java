package com.wd.tools.estools.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wd.tools.estools.service.QueryService;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by DimonHo on 2017/10/30.
 */
@RestController
public class QueryController {

    @Autowired
    QueryService queryService;

    @GetMapping("/findAll")
    public String findAll() throws IOException {
        return queryService.getAllData().toString();
    }

    @GetMapping("/getAllDataForRestClient")
    public JSONObject getAllDataForRestClient() throws IOException {

        return queryService.getAllDataForRestClient();
    }
}
