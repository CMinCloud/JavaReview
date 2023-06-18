package com.cm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReviewApplication.class, args);
    }

}
