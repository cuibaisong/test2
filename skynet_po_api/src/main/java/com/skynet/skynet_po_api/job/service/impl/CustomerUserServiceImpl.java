package com.skynet.skynet_po_api.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.skynet.skynet_po_api.job.dao.CustomerUserMapper;
import com.skynet.skynet_po_api.job.model.CustomerUser;
import com.skynet.skynet_po_api.job.service.CustomerUserService;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserServiceImpl extends ServiceImpl<CustomerUserMapper, CustomerUser> implements CustomerUserService {

}

