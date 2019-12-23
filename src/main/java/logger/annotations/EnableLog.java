package logger.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import logger.config.LogConfig;
import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Import(LogConfig.class)
public @interface EnableLog {

}
