package com.danieldev.springajax.controller;

import java.util.List;

import com.danieldev.springajax.domain.Categoria;
import com.danieldev.springajax.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @ModelAttribute("categorias")
    public List<Categoria> getCategorias(){
        return categoriaRepository.findAll();
    }
    
    @GetMapping("/add")
    public String abrirCadastro(){
        return "promo-add";
    }

}
