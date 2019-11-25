package com.projectmaker.projectmaker.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Projeto extends AbstractEntity {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date inicio;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fim;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", inicio=" + inicio +
                ", fim=" + fim +
                '}';
    }
}
