/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Medico;
import br.com.clinica.view.InternalFramePlantao;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author henrique
 */
public class PlantaoControl {

    private InternalFramePlantao iFrame;
    private JInternalFrame internalFrame;
    private List<Medico> medicos;
    private List<Enfermeiro> enfermeiros;

    public PlantaoControl(InternalFramePlantao frame) {
        this.iFrame = frame;
        loadTable();
    }

    public void loadTable() {

    }

}
