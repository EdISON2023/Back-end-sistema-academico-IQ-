package com.example.academico.paralelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParaleloService {

    @Autowired
    private ParaleloRepository paraleloRepository;

    public List<Paralelo> getAllParalelos() {
        return paraleloRepository.findAll();
    }

    public Optional<Paralelo> getParaleloById(Long id) {
        return paraleloRepository.findById(id);
    }

    public Paralelo saveParalelo(Paralelo paralelo) {
        return paraleloRepository.save(paralelo);
    }

    public void deleteParalelo(Long id) {
        paraleloRepository.deleteById(id);
    }
}
