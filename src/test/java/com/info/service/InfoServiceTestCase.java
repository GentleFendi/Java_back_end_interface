package com.info.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.info.domain.Info;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InfoServiceTestCase {
    @Autowired
    private InfoService infoService;
    @Test
    void testGetById(){
        System.out.println(infoService.getById(10));
    }
    @Test
    void testAdd(){
        Info info = new Info();
        info.setName("345");
        info.setGender("男");
        info.setAge(23);
        info.setPhone("6756734");
        info.setNumber(0012);
        info.setPosition("后端开发");
        info.setSalary(2000.00);
        infoService.save(info);
    }
    @Test
    void testUpdate(){
        Info info = new Info();
        info.setId(12);
        info.setName("闪光灯法");
        info.setGender("女");
        info.setAge(34);
        info.setPhone("20345453048");
        info.setNumber(20341);
        info.setPosition("UI");
        info.setSalary(1500.00);
        infoService.updateById(info);
    }
    @Test
    void testDelete(){
        infoService.removeById(12);
    }
    @Test
    void testGetAll(){
        System.out.println(infoService.list(null));
    }
    @Test
    void testGetPage(){
        IPage<Info> page = new Page<Info>(1, 5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        infoService.page(page);
    }
    @Test
    void testGetBy(){
        LambdaQueryWrapper<Info> qw = new LambdaQueryWrapper<>();
        qw.like(Info::getName, "S");
        infoService.list(qw);
    }
}
