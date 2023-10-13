package study.kyh.principle1.log;

import org.springframework.stereotype.Service;

@Service
public class LogDemoService {
    private final MyLogger myLogger;
    // private final ObjectProvider<MyLogger> myLoggerProvider;

    public LogDemoService(MyLogger myLogger) {
        this.myLogger = myLogger;
    }

    public void logic(String id) {
        // MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }

}
