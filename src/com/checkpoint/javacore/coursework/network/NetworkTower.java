package com.checkpoint.javacore.coursework.network;

import java.util.ArrayList;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;

public class NetworkTower {
	private Position position;
	private int range;
	private ArrayList<NetworkOperator> operators;
	private ExecutorService threadService;
	private ThreadFactory factory = new MyThreadFactory();
	private ThreadGroup towerGroup = new ThreadGroup("tower threads");
	private int countMaxThreads;
	
	
	public NetworkTower(int countMaxActivUsers, int range, Position position) {
		this.range = range;
		this.position = position;
		this.threadService = Executors.newFixedThreadPool(countMaxActivUsers, factory);
		this.countMaxThreads = countMaxActivUsers;
		
	}
	
	public boolean isOccupied(){
		return towerGroup.activeCount()==countMaxThreads;
	}
	

	public void AcceptTransaction(Runnable command){
			threadService.execute(command);		
	}
	
	public boolean checkOperators(int idSender, int idReceiver){
		if(idSender==idReceiver){
			return findById(idSender);
		}else{
			return findById(idSender) && findById(idReceiver);
		}
	}
	
	private boolean findById(int id){
		for (NetworkOperator networkOperator : operators) {
			if(networkOperator.getOperatorId()==id){
				return true;
			}
		}
		return false;
	}
	
	public Position getMyPosition(){
		return position;
	}
	
	public int getRange(){
		return range;
	}
	
	public void resetRange(int rangeNew){
		this.range = rangeNew;
	}
	private class MyThreadFactory implements ThreadFactory{

		@Override
		public Thread newThread(Runnable r) {
			return new Thread(towerGroup, r);
		}
	}
	
	
}
