package com.yan.lottery;

import com.alibaba.fastjson.JSON;
import com.yan.lottery.infrastructure.dao.IActivityDao;
import com.yan.lottery.infrastructure.po.Activity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    IActivityDao activityDao;

    @Test
    public void test_insert(){
        Activity activity = new Activity();
        activity.setActivityId(100002L);
        activity.setActivityName("测试活动");
        activity.setActivityDesc("仅用于插入数据测试");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(100);
        activity.setTakeCount(10);
        activity.setState(0);
        activity.setCreator("xiaoyan");
        activityDao.insert(activity);
    }

    @Test
    public void test_select(){
        Activity activity = activityDao.queryActivityById(100002L);
        logger.info("测试结果：｛｝",JSON.toJSONString(activity));
    }
}
