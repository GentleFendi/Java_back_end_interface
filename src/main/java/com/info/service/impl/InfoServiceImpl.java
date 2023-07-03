package com.info.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.info.dao.InfoDao;
import com.info.domain.Info;
import com.info.service.InfoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl extends ServiceImpl<InfoDao, Info> implements InfoService {
    @Autowired
    private InfoDao infoDao;

    @Override
    public IPage<Info> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        infoDao.selectPage(page, null);
        return page;
    }

//    @Override
//    public IPage<Info> getPage(int currentPage, int pageSize, Info info) {
//        LambdaQueryWrapper qw = new LambdaQueryWrapper<Info>();
//
////        qw.like(Strings.isNotEmpty(info.getName()), Info::getName, info.getName());
////        qw.like(Strings.isNotEmpty(info.getGender()), Info::getGender, info.getGender());
////        qw.like(Strings.isNotEmpty(info.getPhone()), Info::getPhone, info.getPhone());
//
//        IPage page = new Page(currentPage, pageSize);
//        infoDao.selectPage(page, qw);
//        return page;
//    }
}
