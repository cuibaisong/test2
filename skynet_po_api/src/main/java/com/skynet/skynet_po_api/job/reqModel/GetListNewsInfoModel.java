package com.skynet.skynet_po_api.job.reqModel;

import lombok.Data;

@Data
public class GetListNewsInfoModel {
    private Integer planInfoId;
    private String startTime;
    private String endTime;
    private String emotion;
    private String mediaPlatformType;

}
