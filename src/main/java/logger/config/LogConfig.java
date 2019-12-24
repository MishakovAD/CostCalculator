package logger.config;

import logger.BPP.LoggerHandlerBeanPostProcessor;
import logger.controller.LogController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {
  @Bean
  public LoggerHandlerBeanPostProcessor loggerHandlerBeanPostProcessor() {
    return new LoggerHandlerBeanPostProcessor();
  }

  @Bean
  public LogController loggerController() {
    return new LogController();
  }
}
