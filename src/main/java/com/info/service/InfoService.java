package com.info.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.info.domain.Info;

public interface InfoService extends IService<Info> {
    IPage<Info> getPage(int currentPage, int pageSize);
//    IPage<Info> getPage(int currentPage, int pageSize, Info info);
}
