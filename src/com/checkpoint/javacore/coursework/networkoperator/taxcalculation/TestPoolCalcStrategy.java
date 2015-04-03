package com.checkpoint.javacore.coursework.networkoperator.taxcalculation;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPoolCalcStrategy {

	@Test
	public void test() {
		assertSame(CurrentNumberCallsStrategy.class, StrategyCalculationPool.getStrategy(CurrentNumberCallsStrategy.class).getClass());
		assertSame(OnePayForThirtyDayStrategy.class, StrategyCalculationPool.getStrategy(OnePayForThirtyDayStrategy.class).getClass());
		assertSame(TaxPerMinutesStrategy.class,StrategyCalculationPool.getStrategy(TaxPerMinutesStrategy.class).getClass());
		
	}

}
