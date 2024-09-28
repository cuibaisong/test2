package com.zt.tw_pom.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.tw_pom.job.dao.TestUserMapper;
import com.zt.tw_pom.job.model.TestUser;
import com.zt.tw_pom.job.service.ITestUserService;
import org.springframework.stereotype.Service;

@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements ITestUserService {
}
