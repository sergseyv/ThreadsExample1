package com.sseyvach.ThreadsEx1.ctrl;

import com.sseyvach.ThreadsEx1.model.Constants;
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

        // первый запуск с дефолтовыми значениями диапазона и шага
        model.addAttribute("valInit", new Inits(Constants.valueStart, Constants.valueFinish, Constants.valueStep));

        return "index";
    }
}
