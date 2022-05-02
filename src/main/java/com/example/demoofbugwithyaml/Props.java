package com.example.demoofbugwithyaml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "some-prefix")
@Validated
public class Props {
    private List<Rule<ErrorCodeMapping>> errorCodeMapping;

    public record ErrorCodeMapping(
            String status,
            Boolean indication1) {
    }
}