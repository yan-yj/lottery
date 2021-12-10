package com.yan.lottery.infrastructure.dao;

import com.yan.lottery.infrastructure.po.Award;

/**
 * IAwardDao
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/9 19:34
 */
public interface IAwardDao {
    Award queryAwardInfo(String awardId);
}
