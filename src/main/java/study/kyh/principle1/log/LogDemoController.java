package study.kyh.principle1.log;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogDemoController {
    @Autowired
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
    // private final ObjectProvider<MyLogger> myLoggerProvider;

    public LogDemoController(LogDemoService logDemoService, MyLogger myLogger) {
        this.logDemoService = logDemoService;
        this.myLogger = myLogger;
    }

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestUrl = request.getRequestURL().toString();
        // MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestUrl(requestUrl);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }

}
