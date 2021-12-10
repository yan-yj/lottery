package com.yan.lottery.infrastructure.dao;

import com.yan.lottery.infrastructure.po.Strategy;

/**
 * IStrategyDao
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/9 19:35
 */
public interface IStrategyDao {
    Strategy queryStrategy(Long strategyId);
}
