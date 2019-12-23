package logger;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import logger.config.LogConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LoggerTest {

  private PrintStream defaultStream = System.out;
  private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  private ApplicationContext applicationContext;

  @Before
  public void setUp() {
    PrintStream printStream = new PrintStream(outputStream);
    System.setOut(printStream);

    applicationContext = new AnnotationConfigApplicationContext(LogConfig.class);
  }

  @Test
  public void testLogger() {
    Logg log = applicationContext.getBean(Logg.class);
    log.logSomething();
    System.setOut(defaultStream);
    assertTrue(outputStream.toString().contains("DEBUG"));
  }

}
