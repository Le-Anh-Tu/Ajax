package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/smartphones")
public class SmartphoneRestController {

    @Autowired
    private ISmartphoneService smartphoneService;

    //Tạo SmartphoneController để hiển thị màn hình tạo mới
    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    //Thêm phương thức hiển thị danh sách sản phẩm vào trong SmartphoneController
    @GetMapping
    public ResponseEntity<Page<Smartphone>> showAll(@RequestParam(name = "q", required = false) Optional<String> q,@PageableDefault(size = 3) Pageable pageable) {
        Page<Smartphone> smartphones;
        if (!q.isPresent()) {
            smartphones = smartphoneService.findAll(pageable);
        } else {
            smartphones = smartphoneService.findAllByProducerContaining(q.get(), pageable);
        }
        if (smartphones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> getById(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> updateSmartphone(@PathVariable Long id, @RequestBody Smartphone smartphone) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            if (smartphone.getId() == null) {
                smartphone.setId(id);
            }
            smartphoneService.save(smartphone);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.OK);
    }



}
