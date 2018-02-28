package com.boke.serviceimpl;

import com.boke.dao.BlogArticleMapper;
import com.boke.pojo.BlogArticle;
import com.boke.service.BaseService;
import com.github.abel533.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogArticleServiceimpl extends BaseService<BlogArticle> {
    @Autowired
    private BlogArticleMapper blogArticleMapper;


    @Override
    public Mapper<BlogArticle> getMapper() {
        return this.blogArticleMapper;
    }
}
