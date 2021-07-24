package com.danieldev.springajax.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.danieldev.springajax.domain.Categoria;
import com.danieldev.springajax.domain.Promocao;
import com.danieldev.springajax.repository.CategoriaRepository;
import com.danieldev.springajax.repository.PromocaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PromocaoRepository promocaoRepository;

    @PostMapping("/save")
    public ResponseEntity<Promocao> salvarPromocao(Promocao promocao){
        promocao.setDtCadastro(LocalDateTime.now());
        promocaoRepository.save(promocao);

        return ResponseEntity.ok().build();
    }

    @ModelAttribute("categorias")
    public List<Categoria> getCategorias(){
        return categoriaRepository.findAll();
    }
    
    @GetMapping("/add")
    public String abrirCadastro(){
        return "promo-add";
    }

}
