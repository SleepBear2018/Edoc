package com.jb.dao;

import com.jb.model.EdocCategory;
import com.jb.model.EdocEntry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
@Component
public interface EdocEntryMapper {
    /*//查询用户记录总数
    public int selectCount();
    //分页查询所有或指定分类的电子文档信息，并按编号降序
    public List<EdocEntry> getAllEdocEntry(@Param("start")int start,@Param("pageSize")int pageSize);*/
    public List<EdocEntry> getAllEdocEntry();

    //添加电子文档信息
    public int addEdocEntry(EdocEntry edocEntry);
    //根据编号查询电子文档信息
    public EdocEntry getEdocEntryById(Integer id);
    //修改电子文档信息
    public int modifyEdocEntry(EdocEntry edocEntry);
    //删除电子文档信息
    public int deleteEdocEntryById(Integer id);
    //根据电子文档分类查询
    public List<EdocEntry> getEdocEntryByCategory(@Param("categoryId")Integer categoryId);
    //分页查询
    public List<EdocEntry> getgetAllEdocEntryByPage(@Param("start")Integer start,@Param("pageSize")Integer pageSize);


}
