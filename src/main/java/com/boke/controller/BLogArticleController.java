package com.boke.controller;

import com.boke.pojo.BlogArticle;
import com.boke.serviceimpl.BlogArticleServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BLogArticleController {

    @Autowired
    private BlogArticleServiceimpl blogArticleServiceimpl;

    @RequestMapping(value = "/query")
    @ResponseBody
    public List<BlogArticle> queryall(){
        List<BlogArticle> query = blogArticleServiceimpl.query();
        return  query;

    }
}
