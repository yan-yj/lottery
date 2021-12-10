package com.yan.lottery.domain.strategy.service.algorithm.impl;

import com.yan.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.yan.lottery.domain.strategy.service.algorithm.BaseAlgorithm;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * DefaultRateRandomDrawAlgorithm
 * 必中奖策略抽奖，排掉已经中奖的概率，重新计算中奖范围
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/9 20:56
 */
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        BigDecimal differenceDenominator = BigDecimal.ZERO;

        List<AwardRateInfo> differenceAwardRateList = new ArrayList<>();
        List<AwardRateInfo> awardRateIntervalValList = awardRateInfoMap.get(strategyId);
        for (AwardRateInfo awardRateInfo : awardRateIntervalValList) {
            if (excludeAwardIds.contains(awardRateInfo)){
                continue;
            }
            differenceAwardRateList.add(awardRateInfo);
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
        }

        if (differenceAwardRateList.size() == 0) {
            return "";
        }
        if (differenceAwardRateList.size() == 1) {
            return differenceAwardRateList.get(0).getAwardId();
        }

        // 获取随机概率值
        SecureRandom secureRandom = new SecureRandom();
        int randomVal = secureRandom.nextInt(100) + 1;

        String awardId = "";
        int cursorVal = 0;
        for (AwardRateInfo awardRateInfo : differenceAwardRateList) {
            int rateVal = awardRateInfo.getAwardRate().divide(differenceDenominator, 2, BigDecimal.ROUND_UP).multiply(BigDecimal.valueOf(100)).intValue();
            if (randomVal <= (cursorVal + rateVal)){
                awardId = awardRateInfo.getAwardId();
                break;
            }
            cursorVal += randomVal;
        }
        return awardId;
    }
}
