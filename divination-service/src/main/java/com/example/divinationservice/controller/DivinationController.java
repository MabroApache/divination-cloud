package com.example.divinationservice.controller;

import com.example.common.dto.DivinationResponse;
import com.example.divinationservice.entity.Hexagram;
import com.example.divinationservice.service.DivinationService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/divination")
@CrossOrigin(origins = "http://localhost:5173")
public class DivinationController {

    private final DivinationService service;

    public DivinationController(DivinationService service) {
        this.service = service;
    }

    @GetMapping("/generate")
    public DivinationResponse generate() {

        List<Integer> gua = service.generateGua();

        List<String> main = new ArrayList<>();
        List<String> changed = new ArrayList<>();

        // 上下翻转用于展示（你这里是对的）
        for (int i = gua.size() - 1; i >= 0; i--) {
            int yao = gua.get(i);

            main.add((yao == 6 || yao == 8) ? "- -" : "——");
            changed.add((yao == 6 || yao == 7) ? "——" : "- -");
        }

        DivinationResponse res = new DivinationResponse();
        res.setGua(gua);
        res.setMainGua(main);
        res.setChangedGua(changed);

        // 🔥 新增：查数据库
        Hexagram hex = service.getHexagram(gua);

        if (hex != null) {
            res.setName(hex.getName());
            res.setUpper(hex.getUpperTrigram());
            res.setLower(hex.getLowerTrigram());
        }

        return res;
    }
}
