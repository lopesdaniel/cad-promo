package com.danieldev.springajax.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.danieldev.springajax.domain.Categoria;
import com.danieldev.springajax.domain.Promocao;
import com.danieldev.springajax.repository.CategoriaRepository;
import com.danieldev.springajax.repository.PromocaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PromocaoRepository promocaoRepository;

    @GetMapping("/list")
    public String listarOfertas(ModelMap model){
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by(Direction.DESC, "dtCadastro"));
        model.addAttribute("promocoes", promocaoRepository.findAll(pageRequest));

        return "promo-list";
    }
   
    @GetMapping("/list/ajax")
    public String listarCards(@RequestParam(name = "page", defaultValue = "1") int page, ModelMap model){
        PageRequest pageRequest = PageRequest.of(page, 1, Sort.by(Direction.DESC, "dtCadastro"));
        model.addAttribute("promocoes", promocaoRepository.findAll(pageRequest));

        return "promo-card";
    }

    @PostMapping("/save")
    public ResponseEntity<?> salvarPromocao(@Valid Promocao promocao, BindingResult bindResult){

        if(bindResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            for(FieldError error : bindResult.getFieldErrors()){
                errors.put(error.getField(), error.getDefaultMessage());
            }

            return ResponseEntity.unprocessableEntity().body(errors);
        }

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
