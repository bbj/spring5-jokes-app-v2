package com.example.spring5jokesappv2.controllers;

import com.example.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    //@Autowired - Spring gonna automatically inject it; but since Spring 4.2, not needed as only 1 constructor
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""}) // "/" => root context
    public String showJoke(Model model) {
        //our model is a Map implementation: attr / value
        model.addAttribute("joke", jokeService.getJoke());
        //return "index" view => tells Spring to show "index" view
        return "index";
    }
}
