package com.danieldev.springajax.repository;

import com.danieldev.springajax.domain.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
