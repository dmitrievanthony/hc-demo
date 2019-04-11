package com.gridgain.hcdemo;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.gridgain.hcdemo.core.model.Application;
import com.gridgain.hcdemo.core.repository.ApplicationRepository;
import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class HcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcDemoApplication.class, args);
	}
}
