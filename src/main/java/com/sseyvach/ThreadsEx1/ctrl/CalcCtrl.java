package com.sseyvach.ThreadsEx1.ctrl;

import com.sseyvach.ThreadsEx1.model.ChartData;
import com.sseyvach.ThreadsEx1.math.FactorMap;
import com.sseyvach.ThreadsEx1.model.Inits;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CalcCtrl {
    @RequestMapping(value = "calculate", method = RequestMethod.POST)
    public String CalcChart(Inits init, Model model) {

        List<Map<Integer, Integer>> listMaps = FactorMap.getMaps(init.getValStart(), init.getValFinish(), init.getValStep());
        Map<Integer, Integer> map1thread = listMaps.get(0);
        Map<Integer, Integer> map2thread = listMaps.get(1);

        List<ChartData> dataList = new ArrayList<>();

        map1thread.forEach((k, v1) -> {
            dataList.add(new ChartData(k, v1, map2thread.get(k)));
        });

        model.addAttribute("valInit", init);
        model.addAttribute("chartData", dataList);


        return "index";
    }

}


