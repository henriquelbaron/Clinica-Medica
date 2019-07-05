/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.EnfermeiroDaoImpl;
import br.com.clinica.dao.banco.impl.MedicoDaoImpl;
import br.com.clinica.dao.banco.impl.PlantaoEnfermeiroDaoImpl;
import br.com.clinica.dao.banco.impl.PlantaoMedicoDaoImpl;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Pessoa;
import br.com.clinica.domain.PlantaoEnfermeiro;
import br.com.clinica.domain.PlantaoMedico;
import br.com.clinica.domain.tables.PlantaoTable;
import br.com.clinica.view.InternalFramePlantao;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author henrique
 */
public class PlantaoControl {

    private InternalFramePlantao iFrame;
    private PlantaoTable table;
    private DefaultComboBoxModel cbFuncionario;

    public PlantaoControl(InternalFramePlantao frame) {
        this.iFrame = frame;
        loadTable();
    }

    public void addPlantao() {
        if (iFrame.dataAgendar.getDate() != null) {
            Pessoa p = (Pessoa) iFrame.cbFuncionario.getSelectedItem();
            if (p instanceof Medico) {
                Medico m = (Medico) p;
                
            }
        }
    }

    public void listenerGroupButton() {
        cbFuncionario = new DefaultComboBoxModel(iFrame.rbEnfermeira.isSelected()
                ? new EnfermeiroDaoImpl().listar().toArray()
                : new MedicoDaoImpl().listar().toArray());
        iFrame.cbFuncionario.setModel(cbFuncionario);
    }

    private void loadTable() {
        table = new PlantaoTable();
        for (PlantaoMedico m : new PlantaoMedicoDaoImpl().getPlantoesMedico()) {
            table.addRow(m);
        }
        for (PlantaoEnfermeiro plantoesEnfermeiro : new PlantaoEnfermeiroDaoImpl().getPlantoesEnfermeiro()) {
            table.addRow(plantoesEnfermeiro);
        }
        iFrame.tabelaPlantao.setModel(table);
        cbFuncionario = new DefaultComboBoxModel(new MedicoDaoImpl().listar().toArray());
        iFrame.cbFuncionario.setModel(cbFuncionario);
    }

}
