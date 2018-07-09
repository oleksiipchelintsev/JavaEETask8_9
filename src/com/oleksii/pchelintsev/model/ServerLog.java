package com.oleksii.pchelintsev.model;

import java.io.Serializable;

public class ServerLog implements Serializable{
	private long time;
	private int session;
	private String ip;
	
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public int getSession() {
		return session;
	}
	public void setSession(int session) {
		this.session = session;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	@Override
    public String toString() {
        String value = String.valueOf(time) +" "+ String.valueOf(session) +" "+ String.valueOf(ip);
        return value;
    }
}
