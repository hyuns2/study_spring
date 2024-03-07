package study.kyh.principle2.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import study.kyh.principle2.trace.strategy.code.strategy.ContextV2;
import study.kyh.principle2.trace.strategy.code.strategy.StrategyLogic1;
import study.kyh.principle2.trace.strategy.code.strategy.StrategyLogic2;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

}
