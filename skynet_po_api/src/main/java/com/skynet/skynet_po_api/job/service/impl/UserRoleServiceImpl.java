package com.skynet.skynet_po_api.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.skynet.skynet_po_api.job.dao.UserRoleMapper;
import com.skynet.skynet_po_api.job.model.UserRole;
import com.skynet.skynet_po_api.job.service.UserRoleService;
import org.springframework.stereotype.Service;


@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}

