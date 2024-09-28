package com.skynet.skynet_po_api.job.controller;

import com.skynet.skynet_po_api.job.common.APIResponse;
import com.skynet.skynet_po_api.job.model.Customer;
import com.skynet.skynet_po_api.job.model.PlanInfo;
import com.skynet.skynet_po_api.job.service.PlanInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Api(value = "方案信息",tags = "方案信息测试")
@RestController
@RequestMapping("planinfo")
public class PlanInfoController {

    @Resource
    private PlanInfoService planInfoService;


    @RequestMapping(value = "getall",method = RequestMethod.GET)
    public List<PlanInfo> getAll(){
        return planInfoService.list();
    }

    /**
     * 根据ID获取方案信息
     * @param id
     * @return
     */
    @RequestMapping(value = "getById",method = RequestMethod.GET)
    public APIResponse getById(@RequestParam("id") Integer id){
        try{
            return planInfoService.getById(id);
        }catch (Exception ex){
            ex.printStackTrace();
            return APIResponse.error();
        }
    }

    /**
     * 获取当前客户所有分析方案
     * @return
     */
    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public APIResponse getList(){
        try{
            Customer customer =new Customer();
            customer.setId(1);

            return planInfoService.getList(customer);
        }catch (Exception ex){
            ex.printStackTrace();
            return APIResponse.error();
        }
    }

    /**
     * 添加方案
     * @param planInfo
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "添加方案")
    @RequestMapping(value = "add",method= RequestMethod.POST)
    public APIResponse add(@RequestBody PlanInfo planInfo, HttpServletRequest request, HttpServletResponse response){

        try{
            return planInfoService.addPlanInfo(planInfo);
        }catch (Exception ex){
            ex.printStackTrace();
            return APIResponse.error();
        }
    }

    /**
     * 修改方案信息
     * @param planInfo
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "修改方案")
    @RequestMapping(value = "upd",method= RequestMethod.POST)
    public APIResponse upd(@RequestBody PlanInfo planInfo, HttpServletRequest request, HttpServletResponse response){

        try{
            return planInfoService.updatePlanInfo(planInfo);
        }catch (Exception ex){
            ex.printStackTrace();
            return APIResponse.error();
        }
    }

    @ApiOperation(value = "设置方案状态（0未启用，1启用）")
    @RequestMapping(value = "setStatus",method= RequestMethod.GET)
    public APIResponse setStatus(Integer id,Integer status){

        try{
            return planInfoService.setStatus(id,status);
        }catch (Exception ex){
            ex.printStackTrace();
            return APIResponse.error();
        }
    }
}
