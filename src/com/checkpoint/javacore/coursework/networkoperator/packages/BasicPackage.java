package com.checkpoint.javacore.coursework.networkoperator.packages;

import java.util.HashMap;

import com.checkpoint.javacore.coursework.abonent.Information;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GlobalTariif;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.LocalTarif;
import com.checkpoint.javacore.coursework.networkoperator.taxcalculation.StrategyCalculationPool;
import com.checkpoint.javacore.coursework.networkoperator.taxcalculation.TaxCalculatingStrategy;
import com.checkpoint.javacore.coursework.networkoperator.taxcalculation.TaxPerMinutesStrategy;

public class BasicPackage implements MobilePackage {
	private int id;
	private String name;
	private LocalTarif localTarif;
	private GlobalTariif globalTariif;
	private HashMap<Integer, TaxCalculatingStrategy> abonentStrategys = new HashMap<Integer, TaxCalculatingStrategy>();
	
	
	public BasicPackage() {
		// TODO Auto-generated constructor stub
	}

	public BasicPackage(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public MobilePackage setLocalTariff(LocalTarif tariffNew) {
		this.localTarif = tariffNew;
		return this;
	}

	@Override
	public MobilePackage setGlobalTariff(GlobalTariif tariffNew) {
		this.globalTariif = tariffNew;
		return this;
	}

	@Override
	public Information getInformation(Class<Information> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculateCharge(int time, int abonentKey, int foreginOperator) {
		if(!abonentStrategys.containsKey(new Integer(abonentKey))){
			
			abonentStrategys.put(abonentKey, StrategyCalculationPool.getStrategy(TaxPerMinutesStrategy.class));
		}
		if (foreginOperator != -1) {
			return globalTariif.calculateMoneyPay(time,
					abonentStrategys.get(new Integer(abonentKey)), foreginOperator);
		} else {
			return localTarif.calculateMoneyPay(time,
					abonentStrategys.get(new Integer(abonentKey)));
		}
	}

	@Override
	public boolean isUseTariffById(int id) {

		return globalTariif.getId() == id || localTarif.getId() == id;
	}

	@Override
	public boolean isUseDiscountById(int id) {

		return localTarif.isUseDiscountById(id)
				|| globalTariif.isUseDiscountById(id);
	}

	@Override
	public boolean isUseLicenseFeeById(int id) {
		return localTarif.isUseLicenseFeeById(id)
				|| globalTariif.isUseLicenseFeeById(id);
	}

}
