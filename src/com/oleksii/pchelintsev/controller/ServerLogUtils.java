package com.oleksii.pchelintsev.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oleksii.pchelintsev.model.ServerLog;
import com.oleksii.pchelintsev.utils.FileManager;

public class  ServerLogUtils {
	static final long THREE_DAYS_MILLISS = 1000*60*60*24*3;


	public void delete3DaysLongerLogs() {
		deleteLogsInPerioud(new Date(0),new Date((new Date()).getTime()-THREE_DAYS_MILLISS));
	}
	
	public void deleteLogsInPerioud(Date date1, Date date2) {
		ArrayList<ServerLog> strList = FileManager.readLogs();
				
		strList = (ArrayList<ServerLog>) strList.stream().
				filter(log -> (log.getTime()<date1.getTime() || log.getTime()>date2.getTime()));
		
		FileManager.writeLogs(strList);
	}
	
	public synchronized void genereteSomeLogs() {
		ArrayList<ServerLog> logList = new ArrayList();
		int a = 100000000;
		int b = 999999999;
		int c = 0;
		int d = 256;
		
		for(int i=0; i<10; i++) {
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append(c + (int) (Math.random() * d)).append(".")
						.append(c + (int) (Math.random() * d)).append(".").
							append(c + (int) (Math.random() * d)).append(".").
								append(c + (int) (Math.random() * d));
			
			ServerLog servLog = new ServerLog();
			servLog.setIp(strBuilder.toString());
			servLog.setSession(a + (int) (Math.random() * b));
			servLog.setTime(System.currentTimeMillis());
			logList.add(servLog);
		}
		FileManager.writeLogs(logList);
	}
	
	public void showCurrentStateOfLog() {		
		FileManager.readLogs().forEach(log -> System.out.println(log));
	}
}



















