package com.yan.lottery.domain.strategy.repository;

import com.yan.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.yan.lottery.infrastructure.po.Award;

/**
 * IStrategyREpository
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/9 20:30
 */
public interface IStrategyRepository {
    StrategyRich queryStrategyRich(Long strategyId);
    Award queryAward(String awardId);
}
