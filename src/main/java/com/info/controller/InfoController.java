package com.info.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.info.controller.utils.R;
import com.info.domain.Info;
import com.info.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/information")
public class InfoController {
    @Autowired
    private InfoService infoService;
    @GetMapping
    public R getAll(){
        return new R(true, infoService.list());
    }
    @PostMapping
    public R save(@RequestBody Info info){
        return new R(infoService.save(info));
    }
    @PutMapping
    public R update(@RequestBody Info info){
        return new R(infoService.updateById(info));
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(infoService.removeById(id));
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, infoService.getById(id));
    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        IPage<Info> page = infoService.getPage(currentPage, pageSize);
        if(currentPage > page.getPages()){
            page = infoService.getPage((int)page.getPages(), pageSize);
        }
        return new R(true, page);
    }
//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Info info){
//        IPage<Info> page = infoService.getPage(currentPage, pageSize, info);
//        if(currentPage > page.getPages()){
//            page = infoService.getPage((int)page.getPages(), pageSize, info);
//        }
//        return new R(true, page);
//    }
}
