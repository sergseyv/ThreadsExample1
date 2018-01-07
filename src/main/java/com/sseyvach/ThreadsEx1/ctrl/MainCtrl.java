package com.sseyvach.ThreadsEx1.ctrl;

import com.sseyvach.ThreadsEx1.model.FactorMap;
import com.sseyvach.ThreadsEx1.model.ChartData;
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
        final int valFinish = 15000;
        final int valStep = 100;

        List <Map<Integer, Integer>> listMaps = FactorMap.getMaps(valStart, valFinish, valStep);
        Map<Integer, Integer> map1thread = listMaps.get(0);
        Map<Integer, Integer> map2thread = listMaps.get(1);

        List<ChartData> dataList = new ArrayList<>();

        map1thread.forEach((k, v1) -> {
            dataList.add(new ChartData(k, v1, map2thread.get(k)));
        });






    //    model.addAttribute("times1", listTimes.get(0));
   //     model.addAttribute("times2", listTimes.get(1));
        model.addAttribute("chartData", dataList);

        return "index";
    }
}
