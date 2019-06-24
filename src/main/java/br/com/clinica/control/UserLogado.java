/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Pessoa;


/**
 *
 * @author henrique
 */
public class UserLogado {

    public static Medico medico;
    public static Enfermeiro enfermeiro;
    public static Pessoa USUARIO_LOGADO;

    public static Pessoa getUSUARIO_LOGADO() {
        return USUARIO_LOGADO;
    }

    public static void setUSUARIO_LOGADO(Pessoa USUARIO_LOGADO) {
        UserLogado.USUARIO_LOGADO = USUARIO_LOGADO;
    }

    
}
