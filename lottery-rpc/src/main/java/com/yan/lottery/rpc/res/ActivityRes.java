package com.yan.lottery.rpc.res;

import com.yan.lottery.common.Result;
import com.yan.lottery.rpc.dto.ActivityDto;

import java.io.Serializable;

public class ActivityRes implements Serializable {
    private Result result;
    private ActivityDto activityDto;

    public ActivityRes() {
    }

    public ActivityRes(Result result, ActivityDto activityDto) {
        this.result = result;
        this.activityDto = activityDto;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ActivityDto getActivityDto() {
        return activityDto;
    }

    public void setActivityDto(ActivityDto activityDto) {
        this.activityDto = activityDto;
    }
}
