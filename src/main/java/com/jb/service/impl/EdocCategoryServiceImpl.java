package com.jb.service.impl;

import com.jb.dao.EdocCategoryMapper;
import com.jb.dao.EdocEntryMapper;
import com.jb.model.EdocCategory;
import com.jb.service.EdocCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EdocCategoryServiceImpl implements EdocCategoryService {
    @Autowired
    private EdocCategoryMapper edocCategoryMapper;
    //查询电子文档分类
    @Override
    public List<EdocCategory> getAllEdocCategory() {
        return edocCategoryMapper.getAllEdocCategory();
    }


}
