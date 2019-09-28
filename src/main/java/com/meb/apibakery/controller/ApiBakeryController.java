package com.meb.apibakery.controller;

import com.meb.apibakery.model.Cake;
import com.meb.apibakery.model.Cookie;
import com.meb.apibakery.model.Pastrie;
import com.meb.apibakery.service.CakeService;
import com.meb.apibakery.service.CookieService;
import com.meb.apibakery.service.PastrieServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ApiBakeryController {

    @Autowired
    private final CookieService cookieService;
    @Autowired
    private final CakeService cakeService;
    @Autowired
    private final PastrieServices pastrieServices;

    @GetMapping(path = "/isAlive")
    public String test()
    {
        return "I'm Alive!";
    }


    //coockies
    @GetMapping(path = "/coockies")
    public List<Cookie> getAllCookies()
    {
        return cookieService.getAllCookies();
    }

    @GetMapping(path = "/coockies/{id}")
    public Cookie getCoockieId(@PathVariable Integer id)
    {
        return cookieService.getCookieById(id);
    }

    @GetMapping(path = "/coockies/total")
    public int getTotalCoockie()
    {
        return cookieService.getTotalCoockies();
    }

    //CAKES
    @GetMapping(path = "/cakes")
    public List<Cake> getAllCakes()
    {
        return cakeService.getAllCakes();
    }

    @GetMapping(path = "/cakes/{id}")
    public Cake getCakeById(@PathVariable Integer id)
    {
        return cakeService.getCakeById(id);
    }
    @GetMapping(path = "/cakes/total")
    public int getTotalCakes()
    {
        return cakeService.getTotalCakes();
    }


    //pastries
    @GetMapping(path = "/pastries")
    public List<Pastrie> getAllPastries()
    {
        return pastrieServices.getAllPastries();
    }

    @GetMapping(path = "/pastries/{id}")
    public Pastrie getPastriesById(@PathVariable Integer id)
    {
        return pastrieServices.getPastrieById(id);
    }

    @GetMapping(path = "/pastries/total")
    public int getTotalPastries()
    {
        return pastrieServices.getTotalPastries();
    }



}
