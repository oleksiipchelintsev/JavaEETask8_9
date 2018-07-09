package com.oleksii.pchelintsev;

import com.oleksii.pchelintsev.controller.ServerLogUtils;
import com.oleksii.pchelintsev.multithreading.MultithreadingWrite;

public class AppRunner {

	public static void main(String[] args) throws InterruptedException {
		ServerLogUtils utils = new ServerLogUtils();
		//utils.genereteSomeLogs();
		//utils.delete3DaysLongerLogs();
		//utils.deleteLogsInPerioud(new Date(), new Date());
		//utils.showCurrentStateOfLog();
		
		MultithreadingWrite mult = new MultithreadingWrite(utils);
		

		Thread.sleep(10000);
		utils.showCurrentStateOfLog();
    } 
}