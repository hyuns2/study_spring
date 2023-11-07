package study.kyh.mvc.basic.web.frontcontroller.v2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import study.kyh.mvc.basic.domain.member.Member;
import study.kyh.mvc.basic.domain.member.MemberRepository;
import study.kyh.mvc.basic.web.frontcontroller.MyView;
import study.kyh.mvc.basic.web.frontcontroller.v2.ControllerV2;

import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(userName, age);
        memberRepository.save(member);

        request.setAttribute("member", member);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }

}
