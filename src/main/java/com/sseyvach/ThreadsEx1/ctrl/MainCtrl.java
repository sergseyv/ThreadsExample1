package com.sseyvach.ThreadsEx1.ctrl;

import com.sseyvach.ThreadsEx1.model.FactorMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MainCtrl {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(Model model) {
        final int valStart = 10000;
        final int valFinish = 10010;
        List<Map<Integer, Integer>> listTimes = new ArrayList<>();
        listTimes = FactorMap.getMaps(valStart, valFinish);
        model.addAttribute("times1", listTimes.get(0));
        model.addAttribute("times2", listTimes.get(1));
        return "index";
    }
}
