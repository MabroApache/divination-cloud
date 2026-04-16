package com.example.common.dto;

import java.util.List;

public class DivinationResponse {

    private List<Integer> gua;
    private List<String> mainGua;
    private List<String> changedGua;

    private String name;
    private String upper;
    private String lower;

    public List<Integer> getGua() { return gua; }
    public void setGua(List<Integer> gua) { this.gua = gua; }

    public List<String> getMainGua() { return mainGua; }
    public void setMainGua(List<String> mainGua) { this.mainGua = mainGua; }

    public List<String> getChangedGua() { return changedGua; }
    public void setChangedGua(List<String> changedGua) { this.changedGua = changedGua; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUpper() { return upper; }
    public void setUpper(String upper) { this.upper = upper; }

    public String getLower() { return lower; }
    public void setLower(String lower) { this.lower = lower; }
}
