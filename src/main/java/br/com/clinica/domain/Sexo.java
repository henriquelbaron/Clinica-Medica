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

    private String label;

    private Sexo(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
