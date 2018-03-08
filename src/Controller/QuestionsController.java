/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.JeopardyModel;
import Model.QuestionsModel;
import View.GameGUI;
import View.QuestionsGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 *
 * @author AAJ
 */
public class QuestionsController implements ActionListener
{

    private QuestionsModel model;
    private QuestionsGUI view;
    private JeopardyModel jmodel;
    private GameGUI gview;

    public String respuesta;
    public int score;

    public QuestionsController(QuestionsModel model, QuestionsGUI view, String respuesta, int puntaje, GameGUI gview, JeopardyModel jmodel)
    {
        this.model = model;
        this.view = view;
        this.gview = gview;
        this.jmodel = jmodel;
        this.respuesta = respuesta;
        if (gview.c >= 20)
        {
            this.score = puntaje * 2;
        } else
        {
            this.score = puntaje;
        }

        for (JButton button : view.ABC)
        {
            button.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        for (JButton button : view.ABC)
        {
            if (gview.c == 20)
            {
                for (int i = 0; i < gview.scores.length; i++)
                {
                    gview.Scoreboard[i].setText((String.valueOf(gview.scores[i] * 2)));
                }
            }

            if (button == ae.getSource())
            {
                if (button.getText().equals(respuesta))
                {
                    view.statement.setText("<html>CORRECTO!</html>");
                    view.statement.setForeground(Color.green);

                    for (int i = 0; i < view.opciones.length; i++)
                    {
                        if (view.ABC[i].getText().equals(respuesta))
                        {
                            view.ABC[i].setBackground(Color.green);
                            view.ABC[i].setEnabled(false);

                            if (jmodel.jugador1.isSu_turno() == true)
                            {
                                jmodel.jugador1.setPuntuacion(jmodel.jugador1.getPuntuacion() + score);
                                gview.P1.setText(jmodel.jugador1.getNombre() + " " + jmodel.jugador1.getPuntuacion());
                                jmodel.jugador1.setSu_turno(false);
                                jmodel.jugador2.setSu_turno(true);
                            } else if (jmodel.jugador2.isSu_turno() == true)
                            {
                                jmodel.jugador2.setPuntuacion(jmodel.jugador2.getPuntuacion() + score);
                                gview.P2.setText(jmodel.jugador2.getNombre() + " " + jmodel.jugador2.getPuntuacion());
                                jmodel.jugador2.setSu_turno(false);
                                jmodel.jugador1.setSu_turno(true);
                            }
                        } else
                        {
                            view.ABC[i].setEnabled(false);

                            if (jmodel.jugador1.isSu_turno() == true)
                            {
                                jmodel.jugador1.setSu_turno(false);
                                jmodel.jugador2.setSu_turno(true);
                            } else if (jmodel.jugador2.isSu_turno() == true)
                            {
                                jmodel.jugador2.setSu_turno(false);
                                jmodel.jugador1.setSu_turno(true);
                            }
                        }
                    }

                } else
                {
                    view.statement.setText("<html>INCORRECTO!</html>");
                    view.statement.setForeground(Color.red);
                    button.setBackground(Color.red);

                    for (int i = 0; i < view.opciones.length; i++)
                    {
                        if (view.ABC[i].getText().equals(respuesta))
                        {
                            view.ABC[i].setBackground(Color.green);
                            view.ABC[i].setEnabled(false);

                            if (jmodel.jugador1.isSu_turno() == true)
                            {
                                jmodel.jugador1.setSu_turno(false);
                                jmodel.jugador2.setSu_turno(true);
                            } else if (jmodel.jugador2.isSu_turno() == true)
                            {
                                jmodel.jugador2.setSu_turno(false);
                                jmodel.jugador1.setSu_turno(true);
                            }
                        } else
                        {
                            view.ABC[i].setEnabled(false);

                            if (jmodel.jugador1.isSu_turno() == true)
                            {
                                jmodel.jugador1.setSu_turno(false);
                                jmodel.jugador2.setSu_turno(true);
                            } else if (jmodel.jugador2.isSu_turno() == true)
                            {
                                jmodel.jugador2.setSu_turno(false);
                                jmodel.jugador1.setSu_turno(true);
                            }
                        }
                    }
                }

                view.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent)
                    {
                        gview.setVisible(true);
                    }
                });

                gview.c++;
            }
        }
    }
}
