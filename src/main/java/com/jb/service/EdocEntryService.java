package com.jb.service;

import com.jb.model.EdocEntry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EdocEntryService {
    //查询所有的电子文档信息
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
    public List<EdocEntry>getgetAllEdocEntryByPage(int currentPage,int pageSize);
}
