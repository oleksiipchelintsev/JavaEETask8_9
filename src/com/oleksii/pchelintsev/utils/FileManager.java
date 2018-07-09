package com.oleksii.pchelintsev.utils;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.oleksii.pchelintsev.model.ServerLog;

public class FileManager {
	public static synchronized  void writeLogs(ArrayList<ServerLog> serverLogs ) {
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/../log/log.txt",true)))
        {
			
			serverLogs.forEach(log -> { 
				try {
					dos.writeLong(log.getTime());
					dos.writeInt(log.getSession());
					dos.writeUTF(log.getIp());
					} 
				catch (IOException e) {
					e.printStackTrace();
					}
				});
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    } 
	
	public static synchronized ArrayList<ServerLog> readLogs() {
		ArrayList<ServerLog> serverLogs = new ArrayList();
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream("src/../log/log.txt")))
        {
			while(dis.available()>0) {
				ServerLog servLog = new ServerLog();
				servLog.setTime(dis.readLong());
	            servLog.setSession(dis.readInt());
	            servLog.setIp(dis.readUTF());
	            serverLogs.add(servLog);
			}
			
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
		return serverLogs;
	}
}
