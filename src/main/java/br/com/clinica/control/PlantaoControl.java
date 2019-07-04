/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.PlantaoEnfermeiroDaoImpl;
import br.com.clinica.dao.banco.impl.PlantaoMedicoDaoImpl;
import br.com.clinica.domain.PlantaoEnfermeiro;
import br.com.clinica.domain.PlantaoMedico;
import br.com.clinica.domain.tables.PlantaoTable;
import br.com.clinica.view.InternalFramePlantao;

/**
 *
 * @author henrique
 */
public class PlantaoControl {

    private InternalFramePlantao iFrame;
    private PlantaoTable table;

    public PlantaoControl(InternalFramePlantao frame) {
        this.iFrame = frame;
        loadTable();
    }

    public void addPlantao(){
        
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
    }
    
}
