package com.yan.lottery.domain.strategy.repository.impl;

import com.yan.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.yan.lottery.domain.strategy.repository.IStrategyRepository;
import com.yan.lottery.infrastructure.dao.IAwardDao;
import com.yan.lottery.infrastructure.dao.IStrategyDao;
import com.yan.lottery.infrastructure.dao.IStrategyDetailDao;
import com.yan.lottery.infrastructure.po.Award;
import com.yan.lottery.infrastructure.po.Strategy;
import com.yan.lottery.infrastructure.po.StrategyDetail;

import javax.annotation.Resource;
import java.util.List;

/**
 * StrategyRepository
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/9 20:33
 */
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetailList);
    }

    @Override
    public Award queryAward(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }
}
