package com.yan.lottery.interfaces;

import com.yan.lottery.common.Contants;
import com.yan.lottery.common.Result;
import com.yan.lottery.infrastructure.dao.IActivityDao;
import com.yan.lottery.infrastructure.po.Activity;
import com.yan.lottery.rpc.IActivityBooth;
import com.yan.lottery.rpc.dto.ActivityDto;
import com.yan.lottery.rpc.req.ActivityReq;
import com.yan.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Service;
import javax.annotation.Resource;

/**
 * 活动展台
 */
@Service
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;


    @Override
    public ActivityRes queryActivityById(ActivityReq req) {

        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Contants.ResponseCode.SUCCESS.getCode(), Contants.ResponseCode.SUCCESS.getInfo()),activityDto);
    }
}
