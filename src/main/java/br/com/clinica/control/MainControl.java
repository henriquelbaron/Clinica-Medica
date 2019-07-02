/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.control;

import br.com.clinica.domain.Pessoa;
import br.com.clinica.view.ConsultasDialog;
import br.com.clinica.view.FuncionariosInternalFrame;
import br.com.clinica.view.InternalFrameEmergencia;
import br.com.clinica.view.InternalFrameExames;
import br.com.clinica.view.InternalFrameListaExames;
import br.com.clinica.view.InternalFrameListagemVacina;
import br.com.clinica.view.InternalFramePlantao;
import br.com.clinica.view.InternalFrameSala;
import br.com.clinica.view.PacientesInternalFrame;
import br.com.clinica.view.TelaPrincipal;
import javax.swing.JFrame;

/**
 *
 * @author henrique
 */
public class MainControl {

    private JFrame frame = null;
    private InternalFramePlantao plantao = null;
    private PacientesInternalFrame pacientesInternalFrame = null;
    private FuncionariosInternalFrame cadastroFuncionario = null;
    private InternalFrameListagemVacina listarVacina = null;
    private InternalFrameExames exames = null;
    private InternalFrameEmergencia emergencia = null;
    private InternalFrameListaExames listaExames = null;
    private InternalFrameSala sala = null;

    public MainControl(Pessoa usuario, JFrame pai) {
        UserLogado.setUSUARIO_LOGADO(usuario);
        this.frame = pai;
    }

    public void chamarTelaPacientes() {
        if (pacientesInternalFrame == null) {
            pacientesInternalFrame = new PacientesInternalFrame(frame);
            TelaPrincipal.painel.add(pacientesInternalFrame);
            pacientesInternalFrame.setVisible(true);
        } else {
            if (pacientesInternalFrame.isVisible()) {
                pacientesInternalFrame.pack();
            } else {
                TelaPrincipal.painel.add(pacientesInternalFrame);
                pacientesInternalFrame.setVisible(true);
            }
        }
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

    public void chamarTelaExame() {
        if (exames == null) {
            exames = new InternalFrameExames(frame);
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
        ConsultasDialog dlg = new ConsultasDialog(frame, true);
        dlg.setVisible(true);
    }

    public void chamarTelaListagemVacina() {
        if (listarVacina == null) {
            listarVacina = new InternalFrameListagemVacina(frame);
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

    public void chamarTelaCadastroFuncionario() {
        if (cadastroFuncionario == null) {
            cadastroFuncionario = new FuncionariosInternalFrame(frame);
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

}
