package com.skynet.skynet_po_api.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.skynet.skynet_po_api.job.dao.TestUserMapper;
import com.skynet.skynet_po_api.job.model.TestUser;
import com.skynet.skynet_po_api.job.service.ITestUserService;
import org.springframework.stereotype.Service;

@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements ITestUserService {
}
