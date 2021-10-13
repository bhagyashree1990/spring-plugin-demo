package com.spring.plugin.strategy;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class CsvWriter implements WriterPlugin{
    @Override
    public void write(String message) {
        log.info("Writing CSV: {}",message);
    }

    @Override
    public boolean supports(String s) {
        return s.equalsIgnoreCase("csv");
    }
}
