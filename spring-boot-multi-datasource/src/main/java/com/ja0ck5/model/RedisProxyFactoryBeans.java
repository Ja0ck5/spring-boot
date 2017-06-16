//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package com.ja0ck5.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.MonitorThread;
import redis.clients.jedis.RedisProxy;

public class RedisProxyFactoryBeans {
	private static final Logger log = LoggerFactory.getLogger(RedisProxy.class);

	private String name;
	private String host;
	private int port;
	private String pwd;
	private int maxIdle;
	private int maxTotal;
	private int db;
	private boolean hasMonitor = false;
	private MonitorThread monitorThread;
	private Properties properties;
	private RedisProxy proxy;
	private JedisPool jedisPool;

	public RedisProxyFactoryBeans() {
	}

	public RedisProxyFactoryBeans(String propertiesPath) {
		try {
			this.setPropertiesPath(propertiesPath);
		} catch (IOException e) {
			log.error("setPropertiesPath error,the propertiesPath is '{}'", propertiesPath);
		}
	}

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

	public boolean isHasMonitor() {
		return hasMonitor;
	}

	public void setHasMonitor(boolean hasMonitor) {
		this.hasMonitor = hasMonitor;
	}

	public MonitorThread getMonitorThread() {
		return monitorThread;
	}

	public void setMonitorThread(MonitorThread monitorThread) {
		this.monitorThread = monitorThread;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public void destroy() throws Exception {
		if (null != this.monitorThread) {
			this.monitorThread.interrupt();
		}

		try {
			if (null != this.jedisPool) {
				this.jedisPool.close();
			}

			log.info("Closing redis client: " + this.name);
		} catch (Exception var2) {
			log.error("Error closing redis client: " + this.name, var2);
		}

	}

	public /*RedisProxy*/ RedisProxyFactoryBeans build() throws Exception {
		this.buildPool();
		this.proxy = new RedisProxy(this.jedisPool, this.name, this.host, this.port, this.pwd);
		if (null != this.monitorThread) {
			this.monitorThread.interrupt();
		}

		if (this.hasMonitor) {
			this.monitorThread = new MonitorThread(this.proxy);
		} else {
			this.monitorThread = null;
		}
//		return this.proxy;
		return this;
	}

	private void buildPool() {
		// 校验
		if (!validate()) {
			return;
		}
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(this.maxIdle);
		config.setMaxTotal(this.maxTotal);
		if (this.db > 0) {
			this.jedisPool = new JedisPool(config, this.host, this.port, 0, this.pwd, this.db);
		} else if (null == this.pwd) {
			this.jedisPool = new JedisPool(config, this.host, this.port, 0);
		} else {
			this.jedisPool = new JedisPool(config, this.host, this.port, 0, this.pwd);
		}

	}

	/**
	 * TODO 校验属性
	 * 
	 * @return
	 */
	private boolean validate() {
		boolean flag = false;
		if (null != properties) {
			this.settings();
			flag = true;
			return flag;
		}

		if (StringUtils.isNotBlank(this.host) || port > 0) {
			flag = true;
		}

		return flag;
	}

	private void settings() {
		if (null == this.properties) {
			throw new RuntimeException("no such properties!");
		} else {
			this.name = StringUtils.trimToNull(this.properties.getProperty("name"));
			this.host = StringUtils.trimToNull(this.properties.getProperty("host"));
			this.port = Integer.parseInt(this.properties.getProperty("port"));
			this.pwd = StringUtils.trimToNull(this.properties.getProperty("pwd"));
			this.maxIdle = Integer.parseInt(this.properties.getProperty("maxIdle"));
			this.maxTotal = Integer.parseInt(this.properties.getProperty("maxTotal"));
			String dbStr = this.properties.getProperty("db");
			if (StringUtils.isNotBlank(dbStr)) {
				this.db = Integer.parseInt(dbStr);
			}

			if ("0".equals(StringUtils.trimToNull(this.properties.getProperty("monitor")))) {
				this.hasMonitor = false;
			} else {
				this.hasMonitor = true;
			}

		}
	}

	public RedisProxy getObject() throws Exception {
		return this.proxy;
	}

	public Class<RedisProxy> getObjectType() {
		return RedisProxy.class;
	}

	public boolean isSingleton() {
		return false;
	}

	public void setPropertiesPath(String propertiesPath) throws IOException {
		if (StringUtils.isNotBlank(propertiesPath)) {
			InputStream input = this.getClass().getClassLoader().getResourceAsStream(propertiesPath);
			this.properties = new Properties();
			this.properties.load(input);
			IOUtils.closeQuietly(input);
		}

	}
}
