package com.checkpoint.javacore.coursework.network;

import java.util.ArrayList;

import com.checkpoint.javacore.coursework.abonent.Abonent;
import com.checkpoint.javacore.coursework.abonent.operations.OperationCommand;

public class Ground {
	private ArrayList<NetworkTower> towers = new ArrayList<NetworkTower>();
	double minPos;
	
	
	public void addTower(NetworkTower...tower){
		for (NetworkTower towerNew : tower) {
			towers.add(towerNew);
		}
	}
	
	
	public void makeTransaction(Abonent abonent, OperationCommand command){
		findNetworkTower(abonent, command.getResieverId()).AcceptTransaction(command);
	}
	
	private NetworkTower findNetworkTower(Abonent abonent, int foreginOperatorID){
		double min = Double.MAX_VALUE;
		NetworkTower nearestTower = null;
		for (NetworkTower networkTower : towers) {
			if(!networkTower.isOccupied())
			if(isCoverage(networkTower.getMyPosition(),abonent.getMyPosition(), networkTower.getRange())){
				if(min > minLength()){
					min = minLength();
					nearestTower = networkTower;
				}
			}
		}
		return nearestTower;
	}


	private boolean isCoverage(Position a, Position b, int range) {
		minPos = Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2));
		if (range < minPos)
			return false;
		else
			return true;
	}
	
	private double minLength(){
		return minPos;
	}
	
}
