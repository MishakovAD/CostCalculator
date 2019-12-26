package Launcher;

import cc.config.CostsCalculatorConfig;
import logger.annotations.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("cc")
public class Launcher {
    public static void main(String[] args) {
        //ApplicationContext context = new AnnotationConfigApplicationContext("cc", "logger");
        ConfigurableApplicationContext context = SpringApplication.run(Launcher.class);
        System.out.println();
    }
}
