package com.checkpoint.javacore.coursework.abonent.operations;

import com.checkpoint.javacore.coursework.abonent.Abonent;

public interface OperationCommand extends Runnable{
	int getResieverId();
	OperationCommand setResiever(Abonent abonent);
}
