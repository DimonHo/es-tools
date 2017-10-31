package com.wd.tools.estools.service;

import com.alibaba.fastjson.JSONObject;
import com.wd.tools.estools.Dao.RestClientDao;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;

/**
 * Created by DimonHo on 2017/10/30.
 */
@Service
public class QueryService {

    @Autowired
    private TransportClient client;

    @Autowired
    private RestClientDao restClientDao;

    public SearchResponse getAllData(){
        SearchResponse response = client.prepareSearch("journal_navication5.0").setTypes("titles").setQuery(QueryBuilders.matchAllQuery()).get();
        return response;
    }

    public JSONObject getAllDataForRestClient(){
        try {
            return restClientDao.matchAll("journal_navication5.0","titles");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
