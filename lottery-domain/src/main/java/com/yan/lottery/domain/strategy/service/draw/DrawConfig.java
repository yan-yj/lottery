package com.yan.lottery.domain.strategy.service.draw;

import com.yan.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DrawConfig
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/10 12:14
 */
public class DrawConfig {
    @Resource
    private IDrawAlgorithm defaultRateRandomDrawAlgorithm;

    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        drawAlgorithmMap.put(1,defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(2,singleRateRandomDrawAlgorithm);
    }
}
