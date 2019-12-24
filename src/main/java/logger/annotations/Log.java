package logger.annotations;

import logger.controller.LogType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    LogType type() default LogType.CONSOLE;
    String filePath() default "";
}
