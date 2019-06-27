/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.domain.Exame;
import br.com.clinica.view.InternalFrameExames;
import br.com.clinica.view.InternalFrameResultado;
import br.com.clinica.view.TelaPrincipal;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author Henrique Baron
 */
public class ExameControl {

    private JFrame frame;
    private JInternalFrame internalFrame;
    private List<Exame> exames;
    private InternalFrameResultado resultado = null;

    public void chamarTelaExame() {
        if (resultado == null) {
            resultado = new InternalFrameResultado();
            TelaPrincipal.painel.add(resultado);
            resultado.setVisible(true);
        } else {
            if (resultado.isVisible()) {
                resultado.pack();
            } else {
                TelaPrincipal.painel.add(resultado);
                resultado.setVisible(true);
            }
        }
    }

}
