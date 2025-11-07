package net.serghini.tp1_ex3;

import net.serghini.tp1_ex3.configuration.RsaKeys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeys.class)

@EnableFeignClients(basePackages = "net.serghini.tp1_ex3.client")
public class Tp1Ex3Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp1Ex3Application.class, args);
    }

}
