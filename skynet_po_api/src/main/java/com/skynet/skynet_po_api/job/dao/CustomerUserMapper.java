package com.skynet.skynet_po_api.job.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.skynet.skynet_po_api.job.model.CustomerUser;

@Mapper
public interface CustomerUserMapper extends BaseMapper<CustomerUser> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<CustomerUser> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<CustomerUser> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<CustomerUser> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<CustomerUser> entities);

}

