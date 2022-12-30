package cn.lightina.managebooks.controller;

import cn.lightina.managebooks.pojo.User;
import cn.lightina.managebooks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/managebooks")
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/loginOut")
    public String loginOut(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return "redirect:/managebooks/login";
    }

    @GetMapping(value = "/detail")
    public String detail(Model model,
                         HttpServletRequest request) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String roleName = request.getParameter("roleName");

        User user = null;
        if (StringUtils.isEmpty(userName)) return "login";
        if (StringUtils.isEmpty(roleName)) return "login";

        if (roleName.equals("1")) {
            user = new User(userName, password);
            User u = userService.checkManager(user);
            if (u == null) return "login";
            model.addAttribute("user", u);
            request.getSession().setAttribute("user", u);
            return "detail_admin";
        } else {
            user = new User(userName, password);
            User u = userService.checkUser(user);
            if (u == null) return "login";
            model.addAttribute("user", u);
            request.getSession().setAttribute("user", u);
            return "detail_user";
        }
    }

    @GetMapping(value = "/homepage")
    public String homepage(Model model,
                           HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "detail_user";
    }

    @GetMapping(value = "admin/homepage")
    public String adminhomepage(Model model,
                           HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "detail_admin";
    }

}
