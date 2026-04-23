package com.example.test.controller;

import com.example.test.entity.PlayerIndex;
import com.example.test.repository.IndexerRepository;
import com.example.test.repository.PlayerRepository;
import com.example.test.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService service;

    @Autowired
    private IndexerRepository indexRepo;

    @Autowired
    private PlayerRepository playerRepo;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("list", service.getAll());
        model.addAttribute("indexes", indexRepo.findAll());
        model.addAttribute("players", playerRepo.findAll());
        model.addAttribute("playerIndex", new PlayerIndex());
        return "index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute PlayerIndex pi, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        service.save(pi);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("playerIndex", service.findById(id));
        model.addAttribute("indexes", indexRepo.findAll());
        model.addAttribute("players", playerRepo.findAll());
        return "index";
    }
}
