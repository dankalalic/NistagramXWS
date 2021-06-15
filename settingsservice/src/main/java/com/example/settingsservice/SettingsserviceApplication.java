package com.example.settingsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SettingsserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SettingsserviceApplication.class, args);
    }

}
