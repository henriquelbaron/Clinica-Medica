/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.EnfermeiroDaoImpl;
import br.com.clinica.dao.banco.impl.MedicoDaoImpl;
import br.com.clinica.dao.banco.impl.PlantaoDaoImpl;
import br.com.clinica.dao.banco.impl.PlantaoEnfermeiroDaoImpl;
import br.com.clinica.dao.banco.impl.PlantaoMedicoDaoImpl;
import br.com.clinica.domain.Enfermeiro;
import br.com.clinica.domain.Medico;
import br.com.clinica.domain.Pessoa;
import br.com.clinica.domain.Plantao;
import br.com.clinica.domain.PlantaoEnfermeiro;
import br.com.clinica.domain.PlantaoMedico;
import br.com.clinica.domain.tables.PlantaoTable;
import br.com.clinica.util.DataUtils;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.view.InternalFramePlantao;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author henrique
 */
public class PlantaoControl {

    private InternalFramePlantao iFrame;
    private PlantaoTable table;
    private DefaultComboBoxModel cbFuncionario;
    private PlantaoEnfermeiroDaoImpl pEnfermeiroDao;
    private PlantaoMedicoDaoImpl pMedicoDao;
    private PlantaoDaoImpl plantaoDao;

    public PlantaoControl(InternalFramePlantao frame) {
        this.iFrame = frame;
        plantaoDao = new PlantaoDaoImpl();
        pMedicoDao = new PlantaoMedicoDaoImpl();
        pEnfermeiroDao = new PlantaoEnfermeiroDaoImpl();
        table = new PlantaoTable();
        loadTable();
        loadConfig();
    }

    public void adicionarPlantao() {
        String hora = iFrame.cbPeriodo.getSelectedItem().equals("Diurno") ? "07:00" : "19:00";
        if (iFrame.dataAgendar.getDate() != null) {
            Date dataPlantao = DataUtils.stringToDate(iFrame.dataAgendar.getDate(), hora);
            Plantao plantao = plantaoDao.buscarPlantao(dataPlantao);
            if (plantao == null) {
                plantao = new Plantao(dataPlantao);
                plantaoDao.salvar(plantao);
            }
            Pessoa p = (Pessoa) iFrame.cbFuncionario.getSelectedItem();
            if (p instanceof Medico) {
                Medico m = (Medico) p;
                if (new PlantaoMedicoDaoImpl().medicoHasPlantao(m, dataPlantao)) {
                    PlantaoMedico pm = new PlantaoMedico();
                    pm.setMedico(m);
                    pm.setPlantao(plantao);
                    pMedicoDao.salvar(pm);
                } else {
                    SendMessenger.error("O funcionario ja possui plantão nesta data!");
                }
            }
            if (p instanceof Enfermeiro) {
                Enfermeiro e = (Enfermeiro) p;
                if (new PlantaoEnfermeiroDaoImpl().enfermeiroHasPlantao(e, dataPlantao)) {
                    PlantaoEnfermeiro pe = new PlantaoEnfermeiro();
                    pe.setEnfermeiro(e);
                    pe.setPlantao(plantao);
                    pEnfermeiroDao.salvar(pe);
                } else {
                    SendMessenger.error("O funcionario ja possui plantão nesta data!");
                }
            }
            loadTable();
        }
    }

    public void buscarPorDataAction() {
        table.clearTable();
        Date data = iFrame.jDateChooser2.getDate();
        for (PlantaoMedico object : pMedicoDao.getPlantoesMedicoDia(data)) {
            table.addRow(object);
        }
        for (PlantaoEnfermeiro object : pEnfermeiroDao.getPlantoesEnfermeiroDia(data)) {
            table.addRow(object);
        }
    }

    public void listenerGroupButton() {
        cbFuncionario = new DefaultComboBoxModel(iFrame.rbEnfermeira.isSelected()
                ? new EnfermeiroDaoImpl().listar().toArray()
                : new MedicoDaoImpl().listar().toArray());
        iFrame.cbFuncionario.setModel(cbFuncionario);
    }

    private void loadTable() {
        table.clearTable();
        for (PlantaoMedico m : pMedicoDao.getPlantoesMedico()) {
            table.addRow(m);
        }
        for (PlantaoEnfermeiro plantoesEnfermeiro : pEnfermeiroDao.getPlantoesEnfermeiro()) {
            table.addRow(plantoesEnfermeiro);
        }
    }

    private void loadConfig() {
        iFrame.tabelaPlantao.setModel(table);
        cbFuncionario = new DefaultComboBoxModel(new MedicoDaoImpl().listar().toArray());
        iFrame.cbFuncionario.setModel(cbFuncionario);
        iFrame.tfPesquisa.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                table.clearTable();
                String nome = iFrame.tfPesquisa.getText();
                if (nome.trim().length() == 0) {
                    loadTable();
                } else {
                    for (PlantaoMedico plantaoMedico : pMedicoDao.findPlantaoMedicoPorNome(nome)) {
                        table.addRow(plantaoMedico);
                    }
                    for (PlantaoEnfermeiro object : pEnfermeiroDao.findPlantaoEnfermeiroPorNome(nome)) {
                        table.addRow(object);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }
}
