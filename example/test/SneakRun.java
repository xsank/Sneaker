package test;

import sneaker.constant.Constant;
import sneaker.core.ISneakRun;

public class SneakRun implements ISneakRun{

	public String sneakRun(){
		System.out.println("old value:"+SneakHandler.TEST);
		SneakHandler.TEST="success";
		System.out.printf("new value:"+SneakHandler.TEST);
		return Constant.EXEC_SUCCESS;
	}
}
