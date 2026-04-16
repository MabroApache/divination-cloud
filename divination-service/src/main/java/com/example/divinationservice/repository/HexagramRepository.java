package com.example.divinationservice.repository;

import com.example.divinationservice.entity.Hexagram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HexagramRepository extends JpaRepository<Hexagram, Integer> {

    Optional<Hexagram> findByBinaryCode(String binaryCode);
}