package com.yan.lottery.domain.strategy.service.algorithm.impl;

import com.yan.lottery.domain.strategy.service.algorithm.BaseAlgorithm;

import java.security.SecureRandom;
import java.util.List;

/**
 * SingleRateRandomDrawAlgorithm
 * 单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/9 20:57
 */
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        assert rateTuple != null;

        int randomVal = new SecureRandom().nextInt(100) + 1;
        int index =super.hashIndex(randomVal);

        String awardId = rateTuple[index];
        if (excludeAwardIds.contains(awardId)){
            return "未中奖";
        }
        return awardId;
    }
}
