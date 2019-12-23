package logger.config;

import logger.BPP.LoggerHandlerBeanPostProcessor;
import logger.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {
  @Bean
  public LoggerHandlerBeanPostProcessor loggerHandlerBeanPostProcessor() {
    return new LoggerHandlerBeanPostProcessor();
  }

  @Bean
  public Logger logger() {
    return new Logger();
  }
}
