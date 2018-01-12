package com.sseyvach.ThreadsEx1.ctrl;

import com.sseyvach.ThreadsEx1.model.ChartData;
import com.sseyvach.ThreadsEx1.factor.FactorMap;
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

    // отработка нажатия кнопки "Calculate!"
    @RequestMapping(value = "calculate", method = RequestMethod.POST)
    public String CalcChart(Inits init, Model model) {

        // получаем список хешмапов с нужными значениями исходных чисел
        // и временем просчета его факториалов
        List<Map<Integer, Integer>> listMaps = FactorMap.getMaps(init.getValStart(), init.getValFinish(), init.getValStep());

        // перепаковываем значения из списка хешмапов в список объектов ChartData,
        // для удобной отправки в JSP
        List<ChartData> chartDataList = new ArrayList<>();
        listMaps.get(0).forEach((key, value) -> {
            chartDataList.add(new ChartData(key, value, listMaps.get(1).get(key)));
        });

        // и отправляем
        model.addAttribute("valInit", init);
        model.addAttribute("chartData", chartDataList);
        return "index";
    }
}


