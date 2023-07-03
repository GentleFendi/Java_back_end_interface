package com.info.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.info.domain.Info;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;

@SpringBootTest
public class InfoDaoTestCase {
    @Autowired
    private InfoDao infoDao;
    @Test
    void testById(){
        System.out.println(infoDao.selectById(4));
    }

//    @Test
//    void testAdd(){
//        Info info = new Info();
//        info.setName("阿妮");
//        info.setGender("男");
//        info.setAge(23);
//        info.setPhone("17346593048");
//        info.setNumber(0012);
//        info.setPosition("后端开发");
//        info.setSalary(2000.00);
//        infoDao.insert(info);
//    }
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
        infoDao.updateById(info);
    }
    @Test
    void testDelete(){
//        infoDao.deleteById(145675);
    }
    @Test
    void testGetAll(){
        System.out.println(infoDao.selectList(null));
    }
    @Test
    void testGetPage(){
        IPage page = new Page(2, 5);
        infoDao.selectPage(page, null);
    }
    @Test
    void testGetBy() {
        LambdaQueryWrapper<Info> qw = new LambdaQueryWrapper<>();
        qw.like(Info::getName, "F");
        infoDao.selectList(qw);
    }
}
