package logger.controller;

import logger.annotations.Log;
import org.springframework.stereotype.Component;

@Log
public class LogController implements LogControllerMBean {
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
