package com.gridgain.hcdemo;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HcDemoAPIApplication {

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(10 * 1000);
		SpringApplication.run(HcDemoAPIApplication.class, args);
	}
}
