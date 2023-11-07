package study.kyh.mvc.basic.web.frontcontroller.v3;

import study.kyh.mvc.basic.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);

}
