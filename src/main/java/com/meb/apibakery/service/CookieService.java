package com.meb.apibakery.service;


import com.meb.apibakery.model.Cake;
import com.meb.apibakery.model.Cookie;
import com.meb.apibakery.model.Pastrie;
import com.meb.apibakery.repository.CakeRepository;
import com.meb.apibakery.repository.CookieRepository;
import com.meb.apibakery.repository.PastrieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CookieService {


    private final CookieRepository cookieRepository;


    ///COOKIES

    public List<Cookie> getAllCookies() {
        return cookieRepository.getAllCookies();
    }

    public List<Cookie> getCookie(Integer from, Integer to) {
        return cookieRepository.getCookies(from, to);
    }

    public int getTotalCoockies() {
        return cookieRepository.getTotalCookies();
    }

    public Cookie getCookieById(Integer id) {
        return cookieRepository.getCookieById(id);
    }




}
