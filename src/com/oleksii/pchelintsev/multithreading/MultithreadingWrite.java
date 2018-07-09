package com.oleksii.pchelintsev.multithreading;

import java.util.ArrayList;
import java.util.List;

import com.oleksii.pchelintsev.controller.ServerLogUtils;
import com.oleksii.pchelintsev.model.ServerLog;



public class MultithreadingWrite implements Runnable{	
	 Thread thread;
	 ServerLogUtils utils;
	 
	 public Thread getThread() {
		return thread;
	}

	public MultithreadingWrite(ServerLogUtils utils) {
		 this.utils = utils;
		 
		 for(int i=0; i<3; i++) {
			 Thread thread = new Thread(this);
			 thread.start();
	     }
	 }
	 
	@Override
	public void run() {
		try {
            for (int i = 0; i < 3; i++) {
            	utils.genereteSomeLogs();
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {     
        
        }
	}	
}
