package com.meb.apibakery.service;

import com.meb.apibakery.model.Cake;
import com.meb.apibakery.repository.CakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CakeService {

    private final CakeRepository cakeRepository;

    public List<Cake> getAllCakes()
    {
        return cakeRepository.getAllCakes();
    }

    public List<Cake> getCake(Integer from,Integer to)
    {
        return cakeRepository.getCakes(from,to);
    }
    public int getTotalCakes()
    {
        return cakeRepository.getTotalCakes();
    }
    public Cake getCakeById(Integer id)
    {
        return cakeRepository.getCakesById(id);
    }


}
