package com.example.test.repository;

import com.example.test.entity.PlayerIndex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerIndexRepository extends JpaRepository<PlayerIndex, Integer> {}
