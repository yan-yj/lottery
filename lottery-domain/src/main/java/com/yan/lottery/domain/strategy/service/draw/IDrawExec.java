package com.yan.lottery.domain.strategy.service.draw;

import com.yan.lottery.domain.strategy.model.req.DrawReq;
import com.yan.lottery.domain.strategy.model.res.DrawResult;

/**
 * IDrawExec
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/10 12:12
 */
public interface IDrawExec {
    DrawResult doDrawExec(DrawReq req);
}
