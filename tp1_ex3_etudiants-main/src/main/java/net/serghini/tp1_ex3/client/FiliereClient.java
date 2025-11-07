package net.serghini.tp1_ex3.client;

import net.serghini.tp1_ex3.dtos.FiliereDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "filiere-service", url = "http://localhost:8083/v1/filieres")
public interface FiliereClient {
    @GetMapping ("/{id}")
    FiliereDto getFiliereById(@PathVariable("id") Long id);
}