package com.skynet.skynet_po_api.job.controller;

import com.skynet.skynet_po_api.job.common.APIResponse;
import com.skynet.skynet_po_api.job.model.Customer;
import com.skynet.skynet_po_api.job.model.CustomerUser;
import com.skynet.skynet_po_api.job.model.PlanInfo;
import com.skynet.skynet_po_api.job.reqModel.GetListNewsInfoModel;
import com.skynet.skynet_po_api.job.service.NewsInfoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "新闻",tags = "新闻API")
@RestController
@RequestMapping("newsinfo")
public class NewsInfoController {

    @Resource
    private NewsInfoService newsInfoService;


    /**
     * 根据ID获取新闻信息
     * @param id
     * @return
     */
    @RequestMapping(value = "getById",method = RequestMethod.GET)
    public APIResponse getById(@RequestParam("id") Integer id){
        try{
            return newsInfoService.getById(id);
        }catch (Exception ex){
            ex.printStackTrace();
            return APIResponse.error();
        }
    }

    /**
     * 获取当前方案的信息列表
     * @return
     */
    @RequestMapping(value = "getList",method = RequestMethod.POST)
    public APIResponse getList(@RequestBody GetListNewsInfoModel getListNewsInfoModel, HttpServletRequest request, HttpServletResponse response){
        try{
            CustomerUser customerUser = new CustomerUser();
            customerUser.setId(1);
            customerUser.setCustomerId(1);
            return newsInfoService.getList(getListNewsInfoModel,customerUser);
        }catch (Exception ex){
            ex.printStackTrace();
            return APIResponse.error();
        }
    }
}
