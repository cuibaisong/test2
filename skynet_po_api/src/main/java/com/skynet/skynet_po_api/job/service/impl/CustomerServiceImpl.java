package com.skynet.skynet_po_api.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.skynet.skynet_po_api.job.dao.CustomerMapper;
import com.skynet.skynet_po_api.job.model.Customer;
import com.skynet.skynet_po_api.job.service.CustomerService;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}

