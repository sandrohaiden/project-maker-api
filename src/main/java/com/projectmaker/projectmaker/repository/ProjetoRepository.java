package com.projectmaker.projectmaker.repository;

import com.projectmaker.projectmaker.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    List<Projeto> findByNomeContainingIgnoreCaseOrderByFimDesc(String nome);
    List<Projeto> findByOrderByFimDesc();
}
