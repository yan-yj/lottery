package com.yan.lottery.domain.strategy.service.draw;

import com.yan.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.yan.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.yan.lottery.infrastructure.po.StrategyDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * DrawBase
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/10 12:19
 */
public class DrawBase extends DrawConfig{
    public void checkAndInitRateDate(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList){
        if (strategyMode != 1){
            return;
        }
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        boolean existRateTuple = drawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) {
            return;
        }

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(),strategyDetail.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId,awardRateInfoList);
    }
}
