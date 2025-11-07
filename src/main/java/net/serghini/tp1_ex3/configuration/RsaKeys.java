package net.serghini.tp1_ex3.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPublicKey;
@ConfigurationProperties(prefix = "rsa")
public record RsaKeys(RSAPublicKey publicKey) {
}
