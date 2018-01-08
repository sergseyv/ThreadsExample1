package com.sseyvach.ThreadsEx1.ctrl;

import com.sseyvach.ThreadsEx1.model.Inits;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainCtrl {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(Model model) {

        model.addAttribute("valInit", new Inits(1000,20000,500));

        return "index";
    }
}
