package com.spring.codeBrasil.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity(name = "tb_brazil") //mapeia a classe como sendo uma tabela
public class Brazil implements Serializable {

    public static List <Brazil> brazilList;
    @Id
    @GeneratedValue
    private Long id;
    private String state;
    private String uf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}