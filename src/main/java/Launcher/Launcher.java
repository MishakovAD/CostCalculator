package Launcher;

import cc.PercistanceLayer.entity.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("cc")
public class Launcher {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Launcher.class);
        System.out.println();
        Entity entity = new Entity() {
        };
    }
}
