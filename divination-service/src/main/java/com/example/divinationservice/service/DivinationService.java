package com.example.divinationservice.service;

import com.example.divinationservice.entity.Hexagram;
import com.example.divinationservice.repository.HexagramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DivinationService {

    private static final Random random = new Random();

    @Autowired
    private HexagramRepository repository;

    private int change(int left, int right) {
        right = right - 1;

        int changeL = (left % 4 == 0) ? 4 : left % 4;

        int changeR;
        if (right == 0) {
            changeR = 0;
        } else if (right % 4 == 0) {
            changeR = 4;
        } else {
            changeR = right % 4;
        }

        return changeL + changeR + 1;
    }

    private int[] threeChange() {
        int right = random.nextInt(48) + 1;
        int left = 49 - right;
        int first = change(left, right);

        int secondStart = 49 - first;
        right = random.nextInt(secondStart - 1) + 1;
        left = secondStart - right;
        int second = change(left, right);

        int thirdStart = 49 - first - second;
        right = random.nextInt(thirdStart - 1) + 1;
        left = thirdStart - right;
        int third = change(left, right);

        return new int[]{first, second, third};
    }

    /**
     * 生成六爻（初爻在下）
     */
    public List<Integer> generateGua() {
        List<Integer> gua = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            int[] changes = threeChange();
            int yao = 49 - (changes[0] + changes[1] + changes[2]);
            gua.add(yao / 4);
        }

        return gua;
    }

    /**
     * 🔥 根据六爻查数据库获取卦信息
     */
    public Hexagram getHexagram(List<Integer> gua) {

        StringBuilder binary = new StringBuilder();

        // gua 已经是 初爻在下 → 直接按顺序拼
        for (int yao : gua) {
            if (yao == 7 || yao == 9) {
                binary.append("1"); // 阳
            } else {
                binary.append("0"); // 阴
            }
        }

        String code = binary.toString();

        // 👉 调试用（一定要看这里）
        System.out.println("binary code: " + code);

        return repository.findByBinaryCode(code).orElse(null);
    }
}