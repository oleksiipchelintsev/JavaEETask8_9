package com.oleksii.pchelintsev;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.oleksii.pchelintsev.log.ServerLog;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class.getName());

	
	public static void main(String[] args) {
		Handler consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(new Formatter() {

			@Override
			public String format(LogRecord record) {
				return record.getLevel() + ": " + record.getMessage() + " : " + new Date() + "\n";
			}
		
		});
		
		Handler fileHandler = null;
		try {
			fileHandler = new FileHandler("src/../log/log.txt", true);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileHandler.setFormatter(new Formatter() {

			@Override
			public String format(LogRecord record) {
				return record.getMessage() + "\n";
			}
		
		});
		
		logger.setUseParentHandlers(false);
		logger.addHandler(consoleHandler);
		logger.addHandler(fileHandler);
		
		
		
		List<ServerLog> logList = new ArrayList();
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
			
			logList.add(new ServerLog(System.currentTimeMillis(), a + (int) (Math.random() * b),strBuilder.toString()));
		}
		
		logList.forEach(str -> logger.info(str.toString()));
		
		
		
		//ServerLog.delete3DaysLongerLogs();
		//ServerLog.deleteLogsInPerioud(new Date(1530981899767L), new Date(1530981899768L));
		
	}
}
