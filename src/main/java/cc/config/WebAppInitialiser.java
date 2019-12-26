package cc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Configuration
public class WebAppInitialiser implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext context
        = new AnnotationConfigWebApplicationContext();
    context.setConfigLocation("cc"); //Сканирует пакет на наличие конфигов
    context.setServletContext(servletContext);

    servletContext.addListener(new ContextLoaderListener(context));
  }
}
