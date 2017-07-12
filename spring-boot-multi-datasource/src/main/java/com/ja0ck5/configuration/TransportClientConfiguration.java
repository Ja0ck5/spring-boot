/*
package com.ja0ck5.configuration;

import com.ja0ck5.model.TransportClientFactoryBean;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

*/
/**
 * Created by Jack on 2017/7/12.
 *//*

@Configuration
public class TransportClientConfiguration {

    @Bean(name = "transportClientFactoryBean",destroyMethod = "destroy")
    @Primary
    @ConfigurationProperties(prefix = "glance.es.home")
    public TransportClientFactoryBean transportClientFactoryBean() throws Exception {
        return new TransportClientFactoryBean();
    }

    @Bean(name="esClient")
    @Primary
    public TransportClient esClient(TransportClientFactoryBean transportClientFactoryBean) throws Exception {
        return transportClientFactoryBean.build();
    }

}
*/
