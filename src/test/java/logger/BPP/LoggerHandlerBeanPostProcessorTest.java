package logger.BPP;

import logger.annotations.Log;
import logger.config.LogConfig;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class LoggerHandlerBeanPostProcessorTest {
    private ApplicationContext context = new AnnotationConfigApplicationContext(LogConfig.class);
    private LoggerHandlerBeanPostProcessor subj = context.getBean(LoggerHandlerBeanPostProcessor.class);
    private TestClass test = new TestClass();

    @Test
    public void testPostProcessBeforeInitialization() {
        subj.postProcessBeforeInitialization(test, "test");
        assertTrue(subj.annotatedBeans.size() > 0);
    }

    @Test
    public void testPostProcessAfterInitialization() {
        subj.postProcessBeforeInitialization(test, "test");
        assertTrue(subj.annotatedBeans.size() > 0);

        AutowireCapableBeanFactory bf = context.getAutowireCapableBeanFactory();
        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(TestClass.class);
        gbd.setAutowireCandidate(true);
        gbd.setScope("singleton");
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) bf;
        registry.registerBeanDefinition("test", gbd);

        ITest test = (ITest) context.getBean("test");

        PrintStream defaultStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        test.doNothing();
        test.getStr();

        System.setOut(defaultStream);
        assertTrue(outputStream.toString().contains("START doNothing()"));
        assertTrue(outputStream.toString().contains("END doNothing()"));
        assertTrue(outputStream.toString().contains("RESULT"));
        assertTrue(outputStream.toString().contains("WARNING"));
    }


    @Log
    @Component
    @NoArgsConstructor
    public static class TestClass implements ITest {
        public void doNothing() {
        }

        @Override
        public String getStr() {
            return null;
        }
    }
    public interface ITest {
        void doNothing();
        String getStr();
    }
}
