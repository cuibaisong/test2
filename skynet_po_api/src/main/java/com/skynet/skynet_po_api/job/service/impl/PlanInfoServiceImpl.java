package com.skynet.skynet_po_api.job.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.skynet.skynet_po_api.job.common.APIResponse;
import com.skynet.skynet_po_api.job.dao.PlanInfoMapper;
import com.skynet.skynet_po_api.job.model.Customer;
import com.skynet.skynet_po_api.job.model.PlanInfo;
import com.skynet.skynet_po_api.job.service.PlanInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.skynet.skynet_po_api.job.common.Utils.isNullOrEmpty;


@Service
public class PlanInfoServiceImpl extends ServiceImpl<PlanInfoMapper, PlanInfo> implements PlanInfoService {

    @Resource
    private PlanInfoMapper planInfoMapper;

    @Override
    public APIResponse addPlanInfo(PlanInfo planInfo) throws Exception {
        if(isNullOrEmpty(planInfo.getTitle())){
            return APIResponse.error("方案标题不能为空");
        }
        if(isNullOrEmpty(planInfo.getSubjectWords())){
            return APIResponse.error("主体词不能为空");
        }
        if(isNullOrEmpty(planInfo.getAnalyseWords())){
            return APIResponse.error("分析词不能为空");
        }
        planInfo.setIsDel(0);
        planInfo.setCreaterId(1);//测试接口随便默认一个账号，正式调试时要从登录账户中获取
        planInfo.setCustomerId(1);//测试接口随便默认一个企业，正式调试时从登录账号中获取
        Date date = new Date();
        planInfo.setCTime(date);
        planInfo.setLastUpdTime(date);
        planInfo.setLastUpdUser(1);//测试接口随便默认一个企业，正式调试时从登录账号中获取

        int id = planInfoMapper.insert(planInfo);

        return id>0?APIResponse.success():APIResponse.error();
    }

    @Override
    public APIResponse updatePlanInfo(PlanInfo planInfo) throws Exception {

        if(planInfo.getId()==null||planInfo.getId()<=0){
            return APIResponse.error("请选择要修改的方案");
        }
        PlanInfo oldPlanInfo = planInfoMapper.selectById(planInfo.getId());
        if(oldPlanInfo==null){
            return APIResponse.error("方案信息不存在");
        }
        if(!isNullOrEmpty(planInfo.getTitle())){
            oldPlanInfo.setTitle(planInfo.getTitle());
        }
        if(!isNullOrEmpty(planInfo.getSubjectWords())){
            oldPlanInfo.setSubjectWords(planInfo.getSubjectWords());
        }
        if(!isNullOrEmpty(planInfo.getAnalyseWords())){
            oldPlanInfo.setAnalyseWords(planInfo.getAnalyseWords());
        }
        if(!isNullOrEmpty(planInfo.getIndustryType())){
            oldPlanInfo.setIndustryType(planInfo.getIndustryType());
        }
        if(!isNullOrEmpty(planInfo.getRemark())){
            oldPlanInfo.setRemark(planInfo.getRemark());
        }
        if(!isNullOrEmpty(planInfo.getExcludeWords())){
            oldPlanInfo.setExcludeWords(planInfo.getExcludeWords());
        }
        Date date = new Date();
        oldPlanInfo.setLastUpdTime(date);
        oldPlanInfo.setLastUpdUser(1);//测试接口随便默认一个企业，正式调试时从登录账号中获取

        int count = planInfoMapper.updateById(oldPlanInfo);

        return count>0?APIResponse.success():APIResponse.error();
    }

    @Override
    public APIResponse setStatus(Integer id, Integer status) throws Exception {
        if(id<=0){
            return APIResponse.error("请选择要修改的方案");
        }
        PlanInfo planInfo = planInfoMapper.selectById(id);
        if(planInfo==null){
            return APIResponse.error("方案不存在");
        }
        switch (status){
            case 0:
            case 1:
                planInfo.setStatus(status);
                break;
            default:
                planInfo.setStatus(0);
                break;
        }

        planInfo.setLastUpdTime(new Date());
        planInfo.setLastUpdUser(1);//测试接口随便默认一个企业，正式调试时从登录账号中获取

        int count = planInfoMapper.updateById(planInfo);

        return count>0?APIResponse.success():APIResponse.error();
    }

    @Override
    public APIResponse getById(Integer id) throws Exception {
        PlanInfo planInfo = planInfoMapper.selectById(id);
        if(planInfo!=null){
            return APIResponse.success(planInfo);
        }
        return APIResponse.error("没有找到方案");
    }

    @Override
    public APIResponse getList(Customer customer) {
        if(customer==null){
            return APIResponse.error("未找到客户信息或者未登录");
        }
        List<PlanInfo> list = planInfoMapper.selectList(new QueryWrapper<PlanInfo>().eq("customer_id", customer.getId()));
        return APIResponse.success(list);
    }
}

