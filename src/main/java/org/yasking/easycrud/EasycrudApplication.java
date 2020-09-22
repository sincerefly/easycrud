package org.yasking.easycrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.yasking.easycrud.data.config.DynamicDataSourceRegister;

@SpringBootApplication
@Import(DynamicDataSourceRegister.class)
public class EasycrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycrudApplication.class, args);
    }

}
