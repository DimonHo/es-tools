package com.wd.tools.estools.Dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.sniff.Sniffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;

/**
 * Created by DimonHo on 2017/10/30.
 */
@Repository
public class RestClientDao {

    @Autowired
    private RestClient restClient;

    public JSONObject matchAll(String index,String type) throws Exception {
        String url = "/"+index+"/"+type+"/_search";
        HttpEntity params = new NStringEntity("{\"query\":{\"match_all\":{}}}", ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest("POST",url, Collections.<String, String>emptyMap(),params);
        String respStr = EntityUtils.toString(response.getEntity(), "utf-8");
        return JSON.parseObject(respStr);
    }
}
