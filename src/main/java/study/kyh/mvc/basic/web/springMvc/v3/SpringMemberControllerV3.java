package study.kyh.mvc.basic.web.springMvc.v3;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import study.kyh.mvc.basic.domain.member.Member;
import study.kyh.mvc.basic.domain.member.MemberRepository;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String userName, @RequestParam("age") int age, Model model) {
        Member member = new Member(userName, age);
        System.out.println("member = " + member);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @RequestMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }

}
