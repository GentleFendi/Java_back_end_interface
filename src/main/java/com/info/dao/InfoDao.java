package com.info.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.info.domain.Info;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InfoDao extends BaseMapper<Info> {
}
