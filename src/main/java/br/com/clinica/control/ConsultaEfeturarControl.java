/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.dao.banco.impl.ConsultaDaoImpl;
import br.com.clinica.domain.Consulta;
import br.com.clinica.domain.Doenca;
import br.com.clinica.domain.Remedio;
import br.com.clinica.util.SendMessenger;
import br.com.clinica.validation.Validator;
import br.com.clinica.view.EfeturarConsulta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Henrique Baron
 */
public class ConsultaEfeturarControl {
    
    private final EfeturarConsulta dlg;
    private final Consulta consulta;
    private DefaultListModel<Remedio> remedioList;
    
    public ConsultaEfeturarControl(EfeturarConsulta aThis, Consulta consulta) {
        this.dlg = aThis;
        this.consulta = consulta;
        remedioList = new DefaultListModel();
        dlg.listRemedio.setModel(remedioList);
        dlg.lblPaciente.setText(consulta.getPaciente().getNome());
    }
    
    public void finalizarAction() {
        if (SendMessenger.confirmAction("Encerrar Consulta?") == 0) {
            consulta.setDiagnostico(dlg.checkBox.isSelected() ? "Não Compareceu" : dlg.tfDescricao.getText());
            consulta.setRealizada(true);
            List<Remedio> remedios = new ArrayList();
            for (int i = 0; i < remedioList.size(); i++) {
                remedios.add(remedioList.get(i));
            }
            consulta.setRemedios(remedios);
            if (new ConsultaDaoImpl().editar(consulta)) {
                SendMessenger.success("Consulta Realizada com Sucesso!");
                dlg.dispose();
            } else {
                SendMessenger.error("Erro!");
            }
        }
    }
    
    public void addRemedioAction() {
        String tfRemedio = dlg.tfRemedio.getText();
        if (Validator.stringValidator(tfRemedio)) {
            Remedio remedio = new Remedio();
            remedio.setConsulta(consulta);
            remedio.setDecricao(dlg.tfDescricao.getText());
            remedio.setNome(tfRemedio);
            remedioList.addElement(remedio);
        } else {
            SendMessenger.error("Nome do Remédio Necessario!");
        }
    }
    
    public void removeRemedioAction() {
        int index = dlg.listRemedio.getSelectedIndex();
        if (index >= 0) {
            remedioList.remove(index);
        }
    }
    
}
