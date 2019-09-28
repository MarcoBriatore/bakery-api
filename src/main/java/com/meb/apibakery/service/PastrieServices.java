package com.meb.apibakery.service;

import com.meb.apibakery.model.Pastrie;
import com.meb.apibakery.repository.PastrieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PastrieServices {

    private final PastrieRepository pastrieRepository;


    public List<Pastrie> getAllPastries()
    {
        return pastrieRepository.getAllPastries();
    }

    public List<Pastrie> getPastries(Integer from, Integer to)
    {
        return pastrieRepository.getPastries(from, to);
    }
    public int getTotalPastries()
    {
        return pastrieRepository.getTotalPastries();
    }

    public Pastrie getPastrieById(Integer id)
    {
        return pastrieRepository.getPastrieById(id);
    }
}
