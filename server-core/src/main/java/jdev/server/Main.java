package jdev.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by pinta on 06.06.2017.
 */
@SpringBootApplication
@ComponentScan({"jdev.server.services","jdev.server.controllers"})
public class Main{

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
