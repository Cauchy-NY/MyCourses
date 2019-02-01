package cn.cauchyny.mycourses;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.cauchyny.mycourses.dao")
public class MyCoursesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCoursesApplication.class, args);
    }

}

