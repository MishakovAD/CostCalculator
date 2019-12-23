package logger;

import logger.annotations.Log;
import logger.config.LogConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Log
@Component
public class Logger implements Logg {

  public void logSomething() {
    System.out.println("LOG");
  }

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(LogConfig.class);
    context.getBean(Logg.class).logSomething();
  }
}
