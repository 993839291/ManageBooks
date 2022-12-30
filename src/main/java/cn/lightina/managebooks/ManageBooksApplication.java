package cn.lightina.managebooks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("cn.lightina.managebooks.dao")
@ServletComponentScan(basePackages = {"cn.lightina.managebooks.filter"})
public class ManageBooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageBooksApplication.class, args);
    }
}
