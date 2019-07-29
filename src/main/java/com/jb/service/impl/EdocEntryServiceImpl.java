package com.jb.service.impl;

import com.jb.dao.EdocEntryMapper;
import com.jb.model.EdocEntry;
import com.jb.service.EdocEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
@Service
public class EdocEntryServiceImpl implements EdocEntryService {
    @Autowired
    private EdocEntryMapper edocEntryMapper;

    @Override
    public List<EdocEntry> getAllEdocEntry() {
        return edocEntryMapper.getAllEdocEntry();
    }

    @Transactional
    @Override
    public int addEdocEntry(EdocEntry edocEntry) {
        return edocEntryMapper.addEdocEntry(edocEntry);
    }

    @Override
    public EdocEntry getEdocEntryById(Integer id) {
        return edocEntryMapper.getEdocEntryById(id);
    }

    @Transactional
    @Override
    public int modifyEdocEntry(EdocEntry edocEntry) {
        return edocEntryMapper.modifyEdocEntry(edocEntry);
    }

    @Transactional
    @Override
    public int deleteEdocEntryById(Integer id) {
        return edocEntryMapper.deleteEdocEntryById(id);
    }

    @Override
    public List<EdocEntry> getEdocEntryByCategory(Integer categoryId) {
        return edocEntryMapper.getEdocEntryByCategory(categoryId);
    }

    @Override
    public List<EdocEntry> getgetAllEdocEntryByPage(int currentPage, int pageSize) {
        int start=(currentPage-1)*pageSize;
        List<EdocEntry> list=edocEntryMapper.getgetAllEdocEntryByPage(start,pageSize);
        System.out.println(list);
        return list;
    }


    /*//分页查询
    @Override
    public List<EdocEntry> getAllEdocEntry(int currentPage) {
        EdocEntry edocEntry=new EdocEntry();
        //每页显示的数据
        int pageSize=5; //页面容量
        edocEntry.setPageSize(pageSize);
        int start=(currentPage-1)*pageSize;
        //封装总记录数
        int totalCount = edocEntryMapper.selectCount();
        edocEntry.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        edocEntry.setTotalPage(num.intValue());

        List<EdocEntry> list=edocEntryMapper.getAllEdocEntry(start,pageSize);
        return list;
        }*/




}
