package com.esi.ms_patient.Proxies;

import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("ordonnenceClient")
    public HttpGraphQlClient getOrdonnanceClient() {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8082/graphql").build();

        return HttpGraphQlClient.builder(webClient).build();
    }

    @Bean
    @Qualifier("rembourecementClient")
    public HttpGraphQlClient getRembourecementClient() {
        WebClient webclient = WebClient.builder().baseUrl("http://localhost:8083/graphql").build();

        return HttpGraphQlClient.builder(webclient).build();
    }

}
