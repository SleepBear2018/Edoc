package com.jb.controller;

import com.jb.model.EdocCategory;
import com.jb.model.EdocEntry;
import com.jb.service.EdocCategoryService;
import com.jb.service.EdocEntryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/edoc")
public class EdocEntryController {
    @Autowired
    private EdocCategoryService edocCategoryService;
    @Autowired
    private EdocEntryService edocEntryService;
    //查询电子文档分类
    @RequestMapping("/getAllEdocCategory")
    public @ResponseBody List<EdocCategory> getAllEdocCategory(){
        List<EdocCategory>list=edocCategoryService.getAllEdocCategory();
        for(EdocCategory d :list){
            System.out.println(d.getName());
        }
        return list;
    }
    /*//分页查询所有的信息
    @RequestMapping("/getAllEdocEntry/{currentPage}")
    public List<EdocEntry> getAllEdocEntry(@PathVariable("currentPage") int currentPage){
        List<EdocEntry> list= edocEntryService.getAllEdocEntry(currentPage);
        for (EdocEntry e:list){
            System.out.println(e.getTitle());
        }
        return list;
    }*/
    @RequestMapping("/getAllEdocEntryByPage")
    public @ResponseBody List<EdocEntry> getAllEdocEntryByPage(@RequestParam("currentPage") Integer currentPage){
        //总页数+list
        if(currentPage==null){
            currentPage=1;

        }

        int pagesize=5;
        List<EdocEntry> list=edocEntryService.getgetAllEdocEntryByPage(currentPage,pagesize);
        System.out.println(list);
        for (EdocEntry a :list){
            System.out.println(a.getId());
        }
        return list;
    }
    @RequestMapping("/getAllEdocEntry")
    public @ResponseBody List<EdocEntry> getAllEdocEntry(){
        List<EdocEntry> list=edocEntryService.getAllEdocEntry();
        System.out.println(list);
        for (EdocEntry a :list){
            System.out.println(a.getId());
        }
        return list;
    }
    @RequestMapping("/addPage")
    public String addPage() {
        return "add";
    }

    @RequestMapping("/saveAdd")
    public String saveAdd(EdocEntry edocEntry){
        System.out.println("添加记录");
        int i=edocEntryService.addEdocEntry(edocEntry);
        System.out.println("i的值为"+i);
      
        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        int i=edocEntryService.deleteEdocEntryById(id);
        System.out.println("i的值为"+i);
        if(i>0){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }
        return "redirect:/";
    }
//    getEdocEntryByCategory

    @RequestMapping("/getEdocEntryByCategory")
    public @ResponseBody List<EdocEntry> getAirQualityIndexByDistrict(@RequestParam("categoryId")Integer categoryId){
        List<EdocEntry> list=edocEntryService.getEdocEntryByCategory(categoryId);
        for (EdocEntry a:list){
            System.out.println(a.getId());
        }
        return list;
    }
    /*根据id查询一条记录*/
    @RequestMapping(value="/update")
    public String findUpdate(@RequestParam("id") Integer id, Model model){

        EdocEntry edo = edocEntryService.getEdocEntryById(id);
        model.addAttribute("id",id);

        //System.out.println("下拉列表的值为"+a.getDistrictId());
        model.addAttribute("monitorTime",edo.getTitle());
        model.addAttribute("summary",edo.getSummary());
        model.addAttribute("title",edo.getTitle());
        model.addAttribute("uploaduser",edo.getUploaduser());
        model.addAttribute("createdate",edo.getCreatedate());

        //model.addAttribute("msg","springboot1");
        return "update";
    }

    @RequestMapping("/saveUpdate")
    public String saveUpdate(EdocEntry edocEntry){

        int i=edocEntryService.modifyEdocEntry(edocEntry);
       
        return "redirect:/";
    }


}
