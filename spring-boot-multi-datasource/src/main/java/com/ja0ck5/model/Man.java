package com.ja0ck5.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Jack on 2017/6/14.
 */
@ConfigurationProperties(prefix = "fhvideo.redis")
public class Man {

	private String name;
	private String host;
	private int port;
	private String pwd;
	private int maxIdle;
	private int maxTotal;
	private int db;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}
}
