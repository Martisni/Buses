package com.sanvalero.buses;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusesConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
