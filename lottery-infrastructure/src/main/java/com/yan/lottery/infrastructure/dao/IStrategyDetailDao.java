package com.yan.lottery.infrastructure.dao;

import com.yan.lottery.infrastructure.po.StrategyDetail;

import java.util.List;

/**
 * IStrategyDetail
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/9 19:36
 */
public interface IStrategyDetailDao {
    List<StrategyDetail> queryStrategyDetailList(Long strategyId);
}
