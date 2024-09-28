package com.skynet.skynet_po_api.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.skynet.skynet_po_api.job.common.APIResponse;
import com.skynet.skynet_po_api.job.model.Customer;
import com.skynet.skynet_po_api.job.model.PlanInfo;

public interface PlanInfoService extends IService<PlanInfo> {

    /**
     * 添加方案
     * @param planInfo
     * @return
     * @throws Exception
     */
    APIResponse addPlanInfo(PlanInfo planInfo) throws Exception;

    /**
     * 修改方案信息
     * @param planInfo
     * @return
     * @throws Exception
     */
    APIResponse updatePlanInfo(PlanInfo planInfo) throws Exception;

    /**
     * 设置方案启用状态
     * @param id
     * @param status（0未启用，1启用）
     * @return
     * @throws Exception
     */
    APIResponse setStatus(Integer id,Integer status) throws Exception;

    /**
     * 根据ID获取信息
     * @param id
     * @return
     * @throws Exception
     */
    APIResponse getById(Integer id) throws Exception;

    /**
     * 获取方案列表
     * @param customer
     * @return
     */
    APIResponse getList(Customer customer);

}

