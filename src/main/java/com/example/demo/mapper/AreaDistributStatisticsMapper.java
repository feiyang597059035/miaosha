package com.example.demo.mapper;

import com.example.demo.model.AreaDistributStatistics;

public interface AreaDistributStatisticsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AreaDistributStatistics record);

    int insertSelective(AreaDistributStatistics record);

    AreaDistributStatistics selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AreaDistributStatistics record);

    int updateByPrimaryKey(AreaDistributStatistics record);
}