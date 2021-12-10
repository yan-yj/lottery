package com.yan.lottery.domain.strategy.service.draw.impl;

import com.yan.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.yan.lottery.domain.strategy.model.req.DrawReq;
import com.yan.lottery.domain.strategy.model.res.DrawResult;
import com.yan.lottery.domain.strategy.repository.IStrategyRepository;
import com.yan.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.yan.lottery.domain.strategy.service.draw.DrawBase;
import com.yan.lottery.domain.strategy.service.draw.IDrawExec;
import com.yan.lottery.infrastructure.po.Award;
import com.yan.lottery.infrastructure.po.Strategy;
import com.yan.lottery.infrastructure.po.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * DrawExecImpl
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/10 12:30
 */
public class DrawExecImpl extends DrawBase implements IDrawExec {
    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        logger.info("抽奖开始，执行策略{}",req.getStrategyId());

        StrategyRich strategyRich = strategyRepository.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();
        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailsList();

        checkAndInitRateDate(req.getStrategyId(), strategy.getStrategyMode(), strategyDetailList);

        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategy.getStrategyMode());
        String awardId = drawAlgorithm.randomDraw(req.getStrategyId(), new ArrayList<>());

        Award award = strategyRepository.queryAward(awardId);

        logger.info("抽奖完成，中奖用户：{}\n奖品:{}\n",req.getuId(),award.getAwardName());

        return new DrawResult(req.getuId(), req.getStrategyId(), awardId, award.getAwardName());
    }
}
