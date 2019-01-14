package com.wjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.wjy.mapper.custom")
@ComponentScan(basePackages = {"com.wjy"})
@EnableScheduling
@EnableAsync
@EnableWebMvc
@EnableSwagger2
public class QSApplication {

    public static void main(String[] args) {
        SpringApplication.run(QSApplication.class, args);
    }

}

