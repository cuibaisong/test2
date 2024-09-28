package com.skynet.skynet_po_api.job.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.skynet.skynet_po_api.job.model.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}

