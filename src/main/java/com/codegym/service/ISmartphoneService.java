package com.codegym.service;

import com.codegym.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartphone);

    void remove(Long id);

    Page<Smartphone> findAll(Pageable pageable);

    Page<Smartphone> findAllByProducerContaining(String producer, Pageable pageable);

}
