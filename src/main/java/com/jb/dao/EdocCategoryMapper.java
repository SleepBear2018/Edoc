package com.jb.dao;

import com.jb.model.EdocCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface EdocCategoryMapper {
    //查询所有电子文档分类
    public List<EdocCategory> getAllEdocCategory();
}
