package com.yan.lottery.domain.strategy.model.req;

/**
 * DrawReq
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/9 20:27
 */
public class DrawReq {
    // 用户 ID
    private String uId;
    // 策略 ID
    private Long strategyId;

    public DrawReq() {
    }

    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
}
