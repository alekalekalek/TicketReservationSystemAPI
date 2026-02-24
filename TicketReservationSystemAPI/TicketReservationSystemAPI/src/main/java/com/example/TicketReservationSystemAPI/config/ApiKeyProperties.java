package com.example.TicketReservationSystemAPI.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiKeyProperties {
    private static final String API_KEY = "e1c11dc9-9f1b-4d13-b3a1-a7f00ea39aca";

    public String getApiKey() {
        return API_KEY;
    }
}
