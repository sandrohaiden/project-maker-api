package com.projectmaker.projectmaker.controller;

import com.projectmaker.projectmaker.exception.ResourceNotFoundException;
import com.projectmaker.projectmaker.model.Projeto;
import com.projectmaker.projectmaker.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProjetoController {
    @Autowired
    ProjetoRepository projetoRepository;

    @GetMapping("/projetos")
    public List<Projeto> getAllProjetos(@RequestParam(value="nome", required=false) String nome){
        if(nome == null)
            return projetoRepository.findByOrderByFimDesc();
        else
            return projetoRepository.findByNomeContainingIgnoreCaseOrderByFimDesc(nome);
    }

    @PostMapping("/projetos")
    public Projeto adicionarProjeto(@Valid @RequestBody Projeto projeto) {
        System.out.println(projeto);
        return projetoRepository.save(projeto);
    }

    @GetMapping("/projetos/{id}")
    public Projeto getItem(@PathVariable(value = "id") Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Projeto", "id", id));
    }

    @PutMapping("/projetos/{id}")
    public Projeto updateItem(@PathVariable(value = "id") Long id, @Valid @RequestBody Projeto newProjeto) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto", "id", id));
        newProjeto.setId(id);
        return projetoRepository.save(newProjeto);
    }

    @DeleteMapping("/projetos/{id}")
    public ResponseEntity<?> deleteSubItem(@PathVariable(value = "id") Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto", "id", id));

        projetoRepository.delete(projeto);

        return ResponseEntity.ok().build();
    }
}
