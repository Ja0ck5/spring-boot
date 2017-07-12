/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ja0ck5.model;



/**
 * TransportClientFactoryBean
 *
 * @author Rizwan Idrees
 * @author Mohsin Husen
 * @author Jakub Vavrik
 * @author Piotr Betkier
 */
/*public class TransportClientFactoryBean {

	private static final Logger logger = LoggerFactory.getLogger(TransportClientFactoryBean.class);
	private String clusterNodes = "61.160.36.225:9310";
	private String clusterName = "es_ouj_sns";
	private Boolean clientTransportSniff = true;
	private Boolean clientIgnoreClusterName = Boolean.FALSE;
	private String clientPingTimeout = "5s";
	private String clientNodesSamplerInterval = "5s";
	private boolean clientConnection = true;
	private TransportClient client;
	private Properties properties;
	static final String COLON = ":";
	static final String COMMA = ",";
	private Settings settings;

	public TransportClientFactoryBean() {
	}

	public TransportClientFactoryBean(String propertiesPath) {
		try {
			this.setPropertiesPath(propertiesPath);
		} catch (IOException e) {
			logger.error("TransportClientFactoryBean setPropertiesPath error,the propertiesPath is '{}'",
					propertiesPath);
		}
	}

	public void destroy() throws Exception {
		try {
			logger.info("Closing elasticSearch  client");
			if (client != null) {
				client.close();
			}
		} catch (final Exception e) {
			logger.error("Error closing ElasticSearch client: ", e);
		}
	}

	public TransportClient getObject() throws Exception {
		return client;
	}

	public Class<TransportClient> getObjectType() {
		return TransportClient.class;
	}

	public boolean isSingleton() {
		return false;
	}

	public TransportClient build() throws Exception {
		this.buildClient();
		return this.client;
	}

	protected void buildClient() throws Exception {
		if (!validate()) {
			logger.debug("not any setting in this Client,settings");
			return;
		}
		client = new TransportClient(this.settings);
		Assert.hasText(clusterNodes, "[Assertion failed] clusterNodes settings missing.");
		for (String clusterNode : split(clusterNodes, COMMA)) {
			String hostName = substringBefore(clusterNode, COLON);
			String port = substringAfter(clusterNode, COLON);
			Assert.hasText(hostName, "[Assertion failed] missing host name in 'clusterNodes'");
			Assert.hasText(port, "[Assertion failed] missing port in 'clusterNodes'");
			logger.info("adding transport node : " + clusterNode + " conn=" + clientConnection);

			if (clientConnection) {
				client.addTransportAddress(new InetSocketTransportAddress(hostName, Integer.valueOf(port)));
			}
		}
		if (clientConnection) {
			client.connectedNodes();
		}
	}

	private Settings settings() {
		if (properties != null) {
			this.clusterNodes = properties.getProperty("cluster.nodes");
			if ("0".equals(properties.getProperty("client.connection"))) {
				clientConnection = false;
			}
			return settingsBuilder().put(properties).build();
		}
		return settingBuild();
	}

	private Settings settingBuild() {
		this.settings = settingsBuilder().put("cluster.name", clusterName)
				.put("client.transport.sniff", clientTransportSniff)
				.put("client.transport.ignore_cluster_name", clientIgnoreClusterName)
				.put("client.transport.ping_timeout", clientPingTimeout)
				.put("client.transport.nodes_sampler_interval", clientNodesSamplerInterval).build();
		return this.settings;
	}

	private boolean validate() {
		boolean flag = false;
		if (null != this.properties) {
			this.settings();
			flag = true;
		} else if (org.apache.commons.lang.StringUtils.isNotBlank(this.clusterName)
				&& Integer.valueOf(StringUtils.substringAfter(clusterNodes, COLON)) > 0) {
			settingBuild();
			flag = true;
		}
		return flag;
	}

	public String getClusterNodes() {
		return clusterNodes;
	}

	public String getClusterName() {
		return clusterName;
	}

	public Boolean getClientTransportSniff() {
		return clientTransportSniff;
	}

	public boolean isClientConnection() {
		return clientConnection;
	}

	public void setClientConnection(boolean clientConnection) {
		this.clientConnection = clientConnection;
	}

	public TransportClient getClient() {
		return client;
	}

	public void setClient(TransportClient client) {
		this.client = client;
	}

	public Properties getProperties() {
		return properties;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	public void setClusterNodes(String clusterNodes) {
		this.clusterNodes = clusterNodes;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public void setClientTransportSniff(Boolean clientTransportSniff) {
		this.clientTransportSniff = clientTransportSniff;
	}

	public String getClientNodesSamplerInterval() {
		return clientNodesSamplerInterval;
	}

	public void setClientNodesSamplerInterval(String clientNodesSamplerInterval) {
		this.clientNodesSamplerInterval = clientNodesSamplerInterval;
	}

	public String getClientPingTimeout() {
		return clientPingTimeout;
	}

	public void setClientPingTimeout(String clientPingTimeout) {
		this.clientPingTimeout = clientPingTimeout;
	}

	public Boolean getClientIgnoreClusterName() {
		return clientIgnoreClusterName;
	}

	public void setClientIgnoreClusterName(Boolean clientIgnoreClusterName) {
		this.clientIgnoreClusterName = clientIgnoreClusterName;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	*//**
	 * @param propertiesPath
	 *            the {@link #setPropertiesPath} to set
	 * @throws IOException
	 *//*
	public void setPropertiesPath(String propertiesPath) throws IOException {
		if (StringUtils.isNotBlank(propertiesPath)) {
			InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesPath);
			properties = new Properties();
			properties.load(input);
			IOUtils.closeQuietly(input);
		}
	}
}*/
