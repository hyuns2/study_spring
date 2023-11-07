package study.kyh.mvc.basic.web.frontcontroller.v2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import study.kyh.mvc.basic.web.frontcontroller.MyView;
import study.kyh.mvc.basic.web.frontcontroller.v1.ControllerV1;
import study.kyh.mvc.basic.web.frontcontroller.v1.controller.MemberFormControllerV1;
import study.kyh.mvc.basic.web.frontcontroller.v1.controller.MemberListControllerV1;
import study.kyh.mvc.basic.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import study.kyh.mvc.basic.web.frontcontroller.v2.controller.MemberFormControllerV2;
import study.kyh.mvc.basic.web.frontcontroller.v2.controller.MemberListControllerV2;
import study.kyh.mvc.basic.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontCOntrollerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service");
        String requestUrl = req.getRequestURI();

        ControllerV2 controller = controllerMap.get(requestUrl);
        if (controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(req, resp);
        view.render(req, resp);
    }

}
