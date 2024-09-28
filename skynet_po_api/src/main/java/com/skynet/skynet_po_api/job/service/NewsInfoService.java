package com.skynet.skynet_po_api.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.skynet.skynet_po_api.job.common.APIResponse;
import com.skynet.skynet_po_api.job.model.CustomerUser;
import com.skynet.skynet_po_api.job.model.NewsInfo;
import com.skynet.skynet_po_api.job.reqModel.GetListNewsInfoModel;

public interface NewsInfoService extends IService<NewsInfo> {

    APIResponse getById(Integer id) throws Exception;

    APIResponse getList(GetListNewsInfoModel getListNewsInfoModel, CustomerUser customerUser) throws Exception;

}

