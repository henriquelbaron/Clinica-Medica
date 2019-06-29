/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.domain.Atendente;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Pessoa;

/**
 *
 * @author henrique
 */
public class UserLogado {

    public static Medico MEDICO;
    public static Enfermeiro ENFERMEIRO;
    public static Atendente ATENDENTE;
    public static Pessoa USUARIO_LOGADO;

    public UserLogado(Pessoa usuario) {
        USUARIO_LOGADO = usuario;
    }

    public static void setUSUARIO_LOGADO(Pessoa USUARIO_LOGADO) {
        if (USUARIO_LOGADO instanceof Medico) {
            MEDICO = (Medico) USUARIO_LOGADO;
        }
        if (USUARIO_LOGADO instanceof Enfermeiro) {
            ENFERMEIRO = (Enfermeiro) USUARIO_LOGADO;
        }
        if (USUARIO_LOGADO instanceof Atendente) {
            ATENDENTE = (Atendente) USUARIO_LOGADO;
        }
    }

    public static Medico getMEDICO() {
        return MEDICO;
    }

    public static Enfermeiro getENFERMEIRO() {
        return ENFERMEIRO;
    }

    public static Atendente getATENDENTE() {
        return ATENDENTE;
    }

}
