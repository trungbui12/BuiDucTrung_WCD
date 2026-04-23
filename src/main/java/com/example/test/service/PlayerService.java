package com.example.test.service;

import com.example.test.entity.PlayerIndex;
import com.example.test.repository.PlayerIndexRepository;
import com.example.test.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepo;

    @Autowired
    private PlayerIndexRepository playerIndexRepo;

    public List<PlayerIndex> getAll() {
        return playerIndexRepo.findAll();
    }

    public void save(PlayerIndex pi) {
        playerIndexRepo.save(pi);
    }

    public void delete(Integer id) {
        playerIndexRepo.deleteById(id);
    }

    public PlayerIndex findById(Integer id) {
        return playerIndexRepo.findById(id).orElse(null);
    }
}