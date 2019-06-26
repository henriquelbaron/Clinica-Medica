/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.view.InternalFrameAgendamentoConsultas;
import br.com.clinica.view.TelaPrincipal;
import com.sun.glass.events.WindowEvent;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author henrique
 */
public class MainControl {

    private JFrame frame;
    private JInternalFrame agendamentoConsulta;
    private JInternalFrame plantao;
    private JInternalFrame cadastroPaciente;
    private JInternalFrame cadastroFuncionario;
    private JInternalFrame sala;
    private JInternalFrame exame;

    public void agendamentoConsultaAction(JFrame frame) {

    }

    public void agendamentoExameAction(JFrame frame) {

    }

    public void agendamentoVacinaAction(JFrame frame) {

    }

    public void medicoProntuarioAction(JFrame frame) {

    }

    public void medicoExameAction(JFrame frame) {

    }

    public void medicoReceitaAction(JFrame frame) {

    }

    public void consultaEmergenciaAction(JFrame frame) {

    }

    public void consultaExameAction(JFrame frame) {

    }

    public void consultaReservaSalaAction(JFrame frame) {

    }

    public void chamarTelaAgendamentoConsultas() {
        agendamentoConsulta = new InternalFrameAgendamentoConsultas();
        TelaPrincipal.painel.add(agendamentoConsulta);
        agendamentoConsulta.setVisible(true);
    }

    void chamarTelaPrincipal() {
        frame = new TelaPrincipal();
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

}
