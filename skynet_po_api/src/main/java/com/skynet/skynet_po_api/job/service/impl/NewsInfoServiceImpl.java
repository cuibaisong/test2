package com.skynet.skynet_po_api.job.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.skynet.skynet_po_api.job.common.APIResponse;
import com.skynet.skynet_po_api.job.dao.NewsInfoMapper;
import com.skynet.skynet_po_api.job.dao.PlanInfoMapper;
import com.skynet.skynet_po_api.job.model.CustomerUser;
import com.skynet.skynet_po_api.job.model.NewsInfo;
import com.skynet.skynet_po_api.job.model.PlanInfo;
import com.skynet.skynet_po_api.job.reqModel.GetListNewsInfoModel;
import com.skynet.skynet_po_api.job.service.NewsInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static com.skynet.skynet_po_api.job.common.Utils.*;


@Service
public class NewsInfoServiceImpl extends ServiceImpl<NewsInfoMapper, NewsInfo> implements NewsInfoService {

    @Resource
    private NewsInfoMapper newsInfoMapper;

    @Resource
    private PlanInfoMapper planInfoMapper;

    @Override
    public APIResponse getById(Integer id) throws Exception {
        NewsInfo newsInfo = newsInfoMapper.selectById(id);
        if(newsInfo != null) {
            return APIResponse.success(newsInfo);
        }
        return APIResponse.error("没找到信息");
    }

    @Override
    public APIResponse getList(GetListNewsInfoModel getListNewsInfoModel, CustomerUser customerUser) throws Exception {
        if(customerUser == null) {
            return APIResponse.error("用户未登录或登录信息已丢失");
        }
        if(getListNewsInfoModel == null) {
            return APIResponse.error("请设置要分析的方案");
        }

        PlanInfo planInfo = planInfoMapper.selectById(getListNewsInfoModel.getPlanInfoId());
        if(planInfo == null) {
            return APIResponse.error("方案信息不存在");
        }
        if(isNullOrEmpty(planInfo.getSubjectWords())&&isNullOrEmpty(planInfo.getAnalyseWords())){
            return APIResponse.error("方案主体词分析词为空，请检查方案信息是否完整");
        }
        if(isNullOrEmpty(getListNewsInfoModel.getStartTime())||isNullOrEmpty(getListNewsInfoModel.getEndTime())){
            return APIResponse.error("请选择时间范围");
        }
        if(!isTimeFormat(getListNewsInfoModel.getStartTime(),"yyyy-MM-dd HH:mm:ss")||!isTimeFormat(getListNewsInfoModel.getEndTime(),"yyyy-MM-dd HH:mm:ss")){
            return APIResponse.error("时间格式异常");
        }

        QueryWrapper<NewsInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("news_post_time", getListNewsInfoModel.getStartTime()) // ge表示大于等于开始时间
                .le("news_post_time", getListNewsInfoModel.getEndTime());
        if(!isNullOrEmpty(getListNewsInfoModel.getEmotion())){
            queryWrapper.eq("news_emotion", getListNewsInfoModel.getEmotion());
        }
        if(!isNullOrEmpty(getListNewsInfoModel.getMediaPlatformType())){
            queryWrapper.eq("platform_name", getListNewsInfoModel.getMediaPlatformType());
        }
        //方案中的主体词和分析词处理
        //主要用于拼接模糊查询语句
        if(!isNullOrEmpty(planInfo.getSubjectWords())||!isNullOrEmpty(planInfo.getAnalyseWords())){
            //拼接条件，当方案的主体词不为空，分析词为空时
            if(!isNullOrEmpty(planInfo.getSubjectWords()) && isNullOrEmpty(planInfo.getAnalyseWords()))
                queryWrapper.and(wrapper ->
                    wrapper.like("news_title", planInfo.getSubjectWords())
                            .or()
                            .like("news_abstract", planInfo.getSubjectWords())
            );
            //当方案的主体词为空，分析词不为空时
            if(isNullOrEmpty(planInfo.getSubjectWords()) && !isNullOrEmpty(planInfo.getAnalyseWords())){
                //拆分分析词
                String[] analyseWords = planInfo.getAnalyseWords().split("|");
                //在查询条件中拼接分析词的or链接语句
                queryWrapper.and(wrapper ->
                        Arrays.stream(analyseWords).forEach(wordStr ->
                                wrapper.like("news_title", wordStr)
                                        .or()
                                        .like("news_abstract",wordStr))

                );
            }
            //当方案的主体词和分析词都不为空时
            if(!isNullOrEmpty(planInfo.getSubjectWords())&&isNullOrEmpty(planInfo.getAnalyseWords())){

                //拆分分析词
                String[] analyseWords = planInfo.getAnalyseWords().split("|");

                // 创建一个新的数组，其大小等于原数组大小加1
                String[] newAnalyseWords = new String[analyseWords.length + 1];
                System.arraycopy(analyseWords, 0, newAnalyseWords, 0, analyseWords.length);

                // 将新元素追加到新数组的末尾
                newAnalyseWords[newAnalyseWords.length - 1] = planInfo.getSubjectWords();

                //在查询条件中拼接分析词的or链接语句
                queryWrapper.and(wrapper ->
                        Arrays.stream(analyseWords).forEach(wordStr ->
                                wrapper.like("news_title", wordStr)
                                        .or()
                                        .like("news_abstract",wordStr))

                );
            }
        }
        List<NewsInfo> list =newsInfoMapper.selectList(queryWrapper);
        return APIResponse.success(list);
    }
}

