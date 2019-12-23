package logger.BPP;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import logger.annotations.Log;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LoggerHandlerBeanPostProcessor implements BeanPostProcessor {
  Map<String, Class> annotatedBeans = new HashMap<String, Class>();

  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    Class<?> beanClass = bean.getClass();
    if (beanClass.isAnnotationPresent(Log.class)) {
      annotatedBeans.put(beanName, beanClass);
    }
    return bean;
  }

  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    final Class annotatedBean = annotatedBeans.get(beanName);
    if (annotatedBean != null) {
      return Proxy.newProxyInstance(annotatedBean.getClassLoader(), annotatedBean.getInterfaces(), (proxy, method, args) -> {
        long startTime = System.nanoTime();
        before(annotatedBean, method, args);
        Object invokeMethod = method.invoke(bean, args);
        after(annotatedBean, method, args, startTime);
        return invokeMethod;
      });
    }
    return bean;
  }

  private void before(Class bean, Method method, Object[] args){
    StringBuilder log = new StringBuilder();
    String methodName = method.getName();
    DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-mm-dd ^ HH:mm:ss");
    log.append("[DEBUG] {START " + methodName + "()} " + LocalDateTime.now().format(f) + " >>>> [" + bean.getName() + ".class] >> [Method: " + methodName + "(");
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
    System.out.println(log.toString());
  }

  private void after(Class bean, Method method, Object[] args, long startTime) {
    long endTime = System.nanoTime();
    StringBuilder log = new StringBuilder();
    String methodName = method.getName();
    DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
    log.append("[DEBUG] {END " + methodName + "()} " + LocalDateTime.now().format(f) + " >>>> [" + bean.getName() + ".class] >> [Method: " + methodName + "()] TIME: " + (endTime - startTime)/1000000 + " ms.");
    System.out.println(log.toString());
  }
}
