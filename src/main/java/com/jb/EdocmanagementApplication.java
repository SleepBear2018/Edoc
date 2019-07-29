package com.jb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.jb.dao")
@EnableTransactionManagement // 启注解事务管理
public class EdocmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdocmanagementApplication.class, args);
    }

}
