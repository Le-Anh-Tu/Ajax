package com.codegym.repository;

import com.codegym.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends PagingAndSortingRepository<Smartphone, Long> {
    Page<Smartphone> findAllByProducerContaining(String producer, Pageable pageable);
}
