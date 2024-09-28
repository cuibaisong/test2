package com.skynet.skynet_po_api.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.skynet.skynet_po_api.job.dao.EmotionInfoMapper;
import com.skynet.skynet_po_api.job.model.EmotionInfo;
import com.skynet.skynet_po_api.job.service.EmotionInfoService;
import org.springframework.stereotype.Service;

@Service
public class EmotionInfoServiceImpl extends ServiceImpl<EmotionInfoMapper, EmotionInfo> implements EmotionInfoService {

}

