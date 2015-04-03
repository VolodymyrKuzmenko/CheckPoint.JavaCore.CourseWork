package com.checkpoint.javacore.coursework.abonent.operations;

import java.util.concurrent.Callable;

public interface OperationCommand extends Runnable{
	int getResieverId();
}
