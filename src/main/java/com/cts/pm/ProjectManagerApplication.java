package com.cts.pm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class ProjectManagerApplication {

   
    private static Logger logger = LoggerFactory.getLogger(ProjectManagerApplication.class);

   
    public static void main(String[] args) {
    	logger.debug("====== ProjectManager application started ======");
        SpringApplication.run(ProjectManagerApplication.class, args);
    }

}
