package servlet.servlet.springmvc.v3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import servlet.servlet.domain.member.Member;
import servlet.servlet.domain.member.MemberRepository;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form"; // 애노테이션 기반 컨트롤러는 모델앤뷰 혹은 스트링으로 반환해도 됨 -> 뷰 이름으로 로직 처리됨
    }

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping()
    public String members(Model model) {

        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping(value = "/save")
    public String save(
        @RequestParam("username") String username,
        @RequestParam("age") int age,
        Model model
    ) {
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }
}
