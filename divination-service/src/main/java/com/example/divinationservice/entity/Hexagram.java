package com.example.divinationservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hexagram")
public class Hexagram {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "upper_trigram")
    private String upperTrigram;

    @Column(name = "lower_trigram")
    private String lowerTrigram;

    @Column(name = "binary_code")
    private String binaryCode;

    // ===== 手写 getter/setter =====

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpperTrigram() {
        return upperTrigram;
    }

    public void setUpperTrigram(String upperTrigram) {
        this.upperTrigram = upperTrigram;
    }

    public String getLowerTrigram() {
        return lowerTrigram;
    }

    public void setLowerTrigram(String lowerTrigram) {
        this.lowerTrigram = lowerTrigram;
    }

    public String getBinaryCode() {
        return binaryCode;
    }

    public void setBinaryCode(String binaryCode) {
        this.binaryCode = binaryCode;
    }
}