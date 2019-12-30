package logger.BPP;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import logger.annotations.Log;
import logger.controller.LogController;
import logger.controller.LogType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LoggerHandlerBeanPostProcessor implements BeanPostProcessor {
  Map<String, Class> annotatedBeans = new HashMap<String, Class>();

  private LogController loggerController;

  public LoggerHandlerBeanPostProcessor() {
    MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
    loggerController = new LogController();
    try {
      platformMBeanServer.registerMBean(loggerController, new ObjectName("logger", "name" ,"loggerController"));
    } catch (InstanceAlreadyExistsException |
             MBeanRegistrationException |
             NotCompliantMBeanException |
             MalformedObjectNameException e) {
      e.printStackTrace();
    }
  }

  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    Class<?> beanClass = bean.getClass();
    if (loggerController.isEnabled() && beanClass.isAnnotationPresent(Log.class)) {
      annotatedBeans.put(beanName, beanClass);
    }
    return bean;
  }

  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    final Class annotatedBean = annotatedBeans.get(beanName);
    if (annotatedBean != null) {
      return Proxy.newProxyInstance(annotatedBean.getClassLoader(), annotatedBean.getInterfaces(), (proxy, method, args) -> {
        long startTime = System.nanoTime();
        startLog(annotatedBean, method, args, bean);
        Object invokeMethod = method.invoke(bean, args);
        endLog(annotatedBean, method, startTime, bean);
        checkResult(invokeMethod, method, bean);
        return invokeMethod;
      });
    }
    return bean;
  }

  private void startLog(Class bean, Method method, Object[] args, Object beanObj){
    StringBuilder log = new StringBuilder();
    String methodName = method.getName();
    DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-mm-dd ^ HH:mm:ss");
    log.append("[DEBUG]   {START " + methodName + "()} " + LocalDateTime.now().format(f) + " >>>> [" + bean.getName() + ".class] >> [Method: " + methodName + "(");
    if (args != null) {
      for (int i = 0; i < args.length; i++) {
        if (args[i] instanceof String) {
          log.append("\"" + args[i] + "\"");
        } else {
          log.append(args[i]);
        }
        if (i != args.length-1) {
          log.append(", ");
        }
      }
    }
    log.append(")]");
    log(log.toString(), beanObj);
  }

  private void endLog(Class bean, Method method, long startTime, Object beanObj) {
    long endTime = System.nanoTime();
    StringBuilder log = new StringBuilder();
    String methodName = method.getName();
    DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
    log.append("[DEBUG]   {END " + methodName + "()} " + LocalDateTime.now().format(f) + " >>>> [" + bean.getName() + ".class] >> [Method: " + methodName + "()] TIME: " + (endTime - startTime)/1000000 + " ms.");
    log(log.toString(), beanObj);
  }

  private void checkResult(Object invokeMethod, Method method, Object bean) {
    String check;
    if ("void".equals(method.getReturnType().getName())) {
      check = "[DEBUG] >>> RESULT " + method.getName() + "() = void method";
    } else {
      if (invokeMethod != null) {
        check = "[DEBUG] >>> RESULT " + method.getName() + "() = " + invokeMethod;
      } else {
        check = "[WARNING] >>> RESULT " + method.getName() + "() = NULL";
      }
    }
    log(check, bean);
  }

  private void log(String log, Object bean) {
    LogType type = bean.getClass().getAnnotation(Log.class).type();
    String filePath = bean.getClass().getAnnotation(Log.class).filePath();
    switch (type) {
      case CONSOLE:
        System.out.println(log);
        break;
      case FILE:
        writeLogToFile(log, filePath);
        break;
      case ALL:
        System.out.println(log);
        writeLogToFile(log, filePath);
        break;
      case NONE:
        break;
    }
  }

  private void writeLogToFile(String log, String filePath) {
    try(FileWriter writer = new FileWriter(filePath + "log.txt", true)) {
      writer.write(log + "\n");
      writer.flush();
    } catch(IOException ex){
      System.out.println(ex.getMessage());
    }
  }
}
