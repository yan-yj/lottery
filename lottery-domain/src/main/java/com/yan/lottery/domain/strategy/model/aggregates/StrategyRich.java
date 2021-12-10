package com.yan.lottery.domain.strategy.model.aggregates;

import com.yan.lottery.infrastructure.po.Strategy;
import com.yan.lottery.infrastructure.po.StrategyDetail;

import java.util.List;

/**
 * StrategyRich
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/9 19:19
 */
public class StrategyRich {
    // 策略ID
    private Long strategyId;
    // 策略配置
    private Strategy strategy;
    // 策略明细
    private List<StrategyDetail> strategyDetailsList;

    public StrategyRich() {
    }

    public StrategyRich(Long strategyId, Strategy strategy, List<StrategyDetail> strategyDetailsList) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetailsList = strategyDetailsList;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<StrategyDetail> getStrategyDetailsList() {
        return strategyDetailsList;
    }

    public void setStrategyDetailsList(List<StrategyDetail> strategyDetailsList) {
        this.strategyDetailsList = strategyDetailsList;
    }
}
