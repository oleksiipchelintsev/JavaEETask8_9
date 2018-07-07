package com.oleksii.pchelintsev.log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServerLog {
	private long time;
	private int session;
	private String ip;
	static final long THREE_DAYS_MILLISS = 1000*60*60*24*3;
	
	public ServerLog(long time, int session, String ip) {
		this.time = time;
		this.session = session;
		this.ip = ip;
	}
	
	
	public static void delete3DaysLongerLogs() {
		deleteLogsInPerioud(new Date(0),new Date((new Date()).getTime()-THREE_DAYS_MILLISS));
	}
	
	public static void deleteLogsInPerioud(Date date1, Date date2) {
		List<String> strList = new ArrayList();
		try(BufferedReader reader = new BufferedReader(new FileReader("src/../log/log.txt")))	//auto-closable
        {
            while(true){
            	String str = reader.readLine();
            	if(str == null) {
            		break;
            	} 
            	
            	long time = Long.parseLong((str.substring(0,str.indexOf(" "))));
            	if(time < date1.getTime() || time > date2.getTime()) {  //attention for long loops in real project!!!
            		strList.add(str);
            		System.out.println("added!!");
            	}
            } 
        } catch (IOException e) {
			e.printStackTrace();
		}
		
		writeLogs(strList);
	}
	
	public static void writeLogs(List<String>strList ) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/../log/log.txt")))	//auto-closable
        {	
			strList.forEach(str -> {
				try {
					writer.write(str+"\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return time + " " + session + " " + ip;
	}
}
