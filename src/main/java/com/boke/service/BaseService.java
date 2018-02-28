package com.boke.service;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseService<T> {

    /**
     * 获取mapper接口
     * @return
     */
    public abstract Mapper<T> getMapper();

    /**
     * 查询全部
     * @return
     */
    public List<T> query(){
        return this.getMapper().select(null);
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public T queryId(Integer id){
        return this.getMapper().selectByPrimaryKey(id);
    }

    /**
     * 根据条件查询一条数据
     * @param t
     * @return
     */
    public T queryOne(T t){
        return this.getMapper().selectOne(t);
    }

    /**
     * 根据条件查询数据
     * @param t
     * @return
     */
    public List<T> queryListbyWhere(T t){
        return this.getMapper().select(t);
    }

    /**
     * 分页查询数据
     * @param t
     * @param page
     * @param rows
     * @return
     */
    public PageInfo<T> queryPageListByWhere(T t, Integer page, Integer rows){
        //设置分页参数
        PageHelper.startPage(page,rows);
        List<T> list=this.getMapper().select(t);
        return new PageInfo<T>(list);
    }

    /**
     * 新增数据
     * @param t
     * @return
     */
    public Integer save(T t){
        return this.getMapper().insert(t);
    }

    /**
     * 选择不为null的字段作为插入数据的字段插入数据
     * @param t
     * @return
     */
    public Integer saveSelective(T t){
        return  this.getMapper().insertSelective(t);
    }

    /**
     * 选择不为null的字段作为更新数据的字段更新数据
     * @param t
     * @return
     */
    public Integer updateSlective(T t){
        return this.getMapper().updateByPrimaryKeySelective(t);
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return
     */
    public Integer deleteId(Integer id){
        return this.getMapper().deleteByPrimaryKey(id);
    }

    /**
     * 批量删除数据
     * @param ids
     * @param clazz
     * @param property
     * @return
     */
    public Integer deleteByIds(List<Object> ids,Class<T> clazz,String property){
        Example example=new Example(clazz);
        example.createCriteria().andIn(property,ids);
        return this.getMapper().deleteByExample(example);
    }

    /**
     * 根据条件查询
     * @param t
     * @return
     */
    public  Integer deleteByWhere(T t){
        return this.getMapper().delete(t);
    }





}
