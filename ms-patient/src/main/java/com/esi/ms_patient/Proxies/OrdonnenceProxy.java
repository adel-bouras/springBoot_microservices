package com.esi.ms_patient.Proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * OrdonnenceProxy
 */
@Configuration
public class OrdonnenceProxy {

    @Bean
    @LoadBalanced
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    @Qualifier("ordonnenceClient")
    public HttpGraphQlClient getOrdonnanceClient(@LoadBalanced WebClient.Builder builder) {
        WebClient webClient = builder.baseUrl("http://ms-ordonnance/graphql").build();

        return HttpGraphQlClient.create(webClient);
    }

    @Bean
    @Qualifier("rembourecementClient")
    public HttpGraphQlClient getRembourecementClient(@LoadBalanced WebClient.Builder builder) {
        WebClient webclient = builder.baseUrl("http://ms-remboursement/graphql").build();

        return HttpGraphQlClient.create(webclient);
    }

}
