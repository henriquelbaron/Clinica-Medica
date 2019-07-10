/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.MedicoDaoImpl;
import br.com.clinica.view.InternalFrameEmergencia;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Luiza Mistro
 */
public class EmergenciaControl {

    private DefaultComboBoxModel cbFuncionario;

    public EmergenciaControl() {
        loadComboBox();
    }

    private void loadComboBox() {
        cbFuncionario = new DefaultComboBoxModel(new MedicoDaoImpl().listar().toArray());
        InternalFrameEmergencia.jComboBox2.setModel(cbFuncionario);
    }

}
