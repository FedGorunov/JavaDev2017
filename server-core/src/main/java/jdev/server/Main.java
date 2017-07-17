package jdev.server;

import jdev.server.services.FileService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by pinta on 06.06.2017.
 */
@SpringBootApplication
@ComponentScan({"jdev.server","services","controllers"})
public class Main{

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public FileService fileService(){
        return new FileService();
    }

}
