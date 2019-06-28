/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.view.InternalFrameAgendaExames;
import br.com.clinica.view.InternalFrameAgendamentoConsultas;
import br.com.clinica.view.CadastroDeFuncionadoInternalFrame;
import br.com.clinica.view.InternalFrameCadastroPaciente;
import br.com.clinica.view.InternalFrameEmergencia;
import br.com.clinica.view.InternalFrameExames;
import br.com.clinica.view.InternalFrameListaExames;
import br.com.clinica.view.InternalFrameListagemVacina;
import br.com.clinica.view.InternalFramePlantao;
import br.com.clinica.view.InternalFrameProntuario;
import br.com.clinica.view.InternalFrameReceita;
import br.com.clinica.view.InternalFrameSala;
import br.com.clinica.view.InternalFrameVacina;
import br.com.clinica.view.TelaPrincipal;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author henrique
 */
public class MainControl {

    private JFrame frame = null;
    private InternalFrameAgendamentoConsultas agendamentoConsulta = null;
    private InternalFramePlantao plantao = null;
    private InternalFrameCadastroPaciente cadastroPaciente = null;
    private CadastroDeFuncionadoInternalFrame cadastroFuncionario = null;
    private InternalFrameAgendaExames AgendaExame = null;
    private InternalFrameVacina vacina = null;
    private InternalFrameListagemVacina listarVacina = null;
    private InternalFrameProntuario prontuario = null;
    private InternalFrameExames exames = null;
    private InternalFrameReceita receita = null;
    private InternalFrameEmergencia emergencia = null;
    private InternalFrameListaExames listaExames = null;
    private InternalFrameSala sala = null;

    public MainControl(Object usuario) {
        
    }

    
    
    public void ChamarTelaReservaSala() {
        if (sala == null) {
            sala = new InternalFrameSala();
            TelaPrincipal.painel.add(sala);
            sala.setVisible(true);
        } else {
            if (sala.isVisible()) {
                sala.pack();
            } else {
                TelaPrincipal.painel.add(sala);
                sala.setVisible(true);
            }
        }
    }

    public void ChamarTelaListaExame() {
        if (listaExames == null) {
            listaExames = new InternalFrameListaExames();
            TelaPrincipal.painel.add(listaExames);
            listaExames.setVisible(true);
        } else {
            if (listaExames.isVisible()) {
                listaExames.pack();
            } else {
                TelaPrincipal.painel.add(listaExames);
                listaExames.setVisible(true);
            }
        }
    }

    public void ChamarTelaEmergencia() {
        if (emergencia == null) {
            emergencia = new InternalFrameEmergencia();
            TelaPrincipal.painel.add(emergencia);
            emergencia.setVisible(true);
        } else {
            if (emergencia.isVisible()) {
                emergencia.pack();
            } else {
                TelaPrincipal.painel.add(emergencia);
                emergencia.setVisible(true);
            }
        }
    }

    public void ChamarTelaReceita() {
        if (receita == null) {
            receita = new InternalFrameReceita();
            TelaPrincipal.painel.add(receita);
            receita.setVisible(true);
        } else {
            if (receita.isVisible()) {
                receita.pack();
            } else {
                TelaPrincipal.painel.add(receita);
                receita.setVisible(true);
            }
        }
    }

    public void chamarTelaExame() {
        if (exames == null) {
            exames = new InternalFrameExames();
            TelaPrincipal.painel.add(exames);
            exames.setVisible(true);
        } else {
            if (exames.isVisible()) {
                exames.pack();
            } else {
                TelaPrincipal.painel.add(exames);
                exames.setVisible(true);
            }
        }
    }

    public void chamarTelaProntuario() {
        if (prontuario == null) {
            prontuario = new InternalFrameProntuario();
            TelaPrincipal.painel.add(prontuario);
            prontuario.setVisible(true);
        } else {
            if (prontuario.isVisible()) {
                prontuario.pack();
            } else {
                TelaPrincipal.painel.add(prontuario);
                prontuario.setVisible(true);
            }
        }
    }

    public void chamarTelaListagemVacina() {
        if (listarVacina == null) {
            listarVacina = new InternalFrameListagemVacina();
            TelaPrincipal.painel.add(listarVacina);
            listarVacina.setVisible(true);
        } else {
            if (listarVacina.isVisible()) {
                listarVacina.pack();
            } else {
                TelaPrincipal.painel.add(listarVacina);
                listarVacina.setVisible(true);
            }
        }
    }

    public void chamarTelaCadastroPaciente() {
        if (cadastroPaciente == null) {
            cadastroPaciente = new InternalFrameCadastroPaciente();
            TelaPrincipal.painel.add(cadastroPaciente);
            cadastroPaciente.setVisible(true);
        } else {
            if (cadastroPaciente.isVisible()) {
                cadastroPaciente.pack();
            } else {
                TelaPrincipal.painel.add(cadastroPaciente);
                cadastroPaciente.setVisible(true);
            }
        }
    }

    public void chamarTelaPlantao() {
        if (plantao == null) {
            plantao = new InternalFramePlantao();
            TelaPrincipal.painel.add(plantao);
            plantao.setVisible(true);
        } else {
            if (plantao.isVisible()) {
                plantao.pack();
            } else {
                TelaPrincipal.painel.add(plantao);
                plantao.setVisible(true);
            }
        }
    }

    public void chamarTelaVacina() {
        if (vacina == null) {
            vacina = new InternalFrameVacina();
            TelaPrincipal.painel.add(vacina);
            vacina.setVisible(true);
        } else {
            if (vacina.isVisible()) {
                vacina.pack();
            } else {
                TelaPrincipal.painel.add(vacina);
                vacina.setVisible(true);
            }
        }
    }

    public void chamarTelaAgendaExames() {
        if (AgendaExame == null) {
            AgendaExame = new InternalFrameAgendaExames();
            TelaPrincipal.painel.add(AgendaExame);
            AgendaExame.setVisible(true);
        } else {
            if (AgendaExame.isVisible()) {
                AgendaExame.pack();
            } else {
                TelaPrincipal.painel.add(AgendaExame);
                AgendaExame.setVisible(true);
            }
        }
    }

    public void chamarTelaAgendamentoConsultas() {
        if (agendamentoConsulta == null) {
            agendamentoConsulta = new InternalFrameAgendamentoConsultas();
            TelaPrincipal.painel.add(agendamentoConsulta);
            agendamentoConsulta.setVisible(true);
        } else {
            if (agendamentoConsulta.isVisible()) {
                agendamentoConsulta.pack();
            } else {
                TelaPrincipal.painel.add(agendamentoConsulta);
                agendamentoConsulta.setVisible(true);
            }
        }
    }

    public void chamarTelaCadastroFuncionario() {
        if (cadastroFuncionario == null) {
            cadastroFuncionario = new CadastroDeFuncionadoInternalFrame();
            TelaPrincipal.painel.add(cadastroFuncionario);
            cadastroFuncionario.setVisible(true);
        } else {
            if (cadastroFuncionario.isVisible()) {
                cadastroFuncionario.pack();
            } else {
                TelaPrincipal.painel.add(cadastroFuncionario);
                cadastroFuncionario.setVisible(true);
            }
        }
    }

//    void chamarTelaPrincipal() {
//        frame = new TelaPrincipal();
//        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }

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

}
