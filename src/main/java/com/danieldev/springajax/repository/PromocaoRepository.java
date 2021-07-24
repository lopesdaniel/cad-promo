package com.danieldev.springajax.repository;

import com.danieldev.springajax.domain.Promocao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocaoRepository extends JpaRepository<Promocao, Long> {
    
}
