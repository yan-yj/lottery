package com.yan.lottery.rpc;

import com.yan.lottery.rpc.req.ActivityReq;
import com.yan.lottery.rpc.res.ActivityRes;

/**
 * 活动展台
 * 1.创建活动
 * 2.更新活动
 * 3.查询活动
 */

public interface IActivityBooth {
    ActivityRes queryActivityById(ActivityReq req);
}
