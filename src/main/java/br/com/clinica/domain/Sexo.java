/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.domain;

/**
 *
 * @author Henrique Baron
 */
public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String sexo;

    private Sexo(String label) {
        this.sexo = label;
    }

    public String getLabel() {
        return sexo;
    }

    @Override
    public String toString() {
        return sexo;
    }
}
