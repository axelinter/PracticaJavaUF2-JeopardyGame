/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GameModel;
import Model.JeopardyModel;
import Model.QuestionsModel;

import View.GameGUI;
import View.QuestionsGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author AAJ
 */
public class GameController implements ActionListener
{

    private QuestionsModel qmodel = new QuestionsModel();
    private JeopardyModel jmodel;

    private GameModel modelo;
    private GameGUI view;

    private String categoria;
    private int puntaje;
    private int valor = 0;

    public String pregunta;
    public String[] opciones;
    public String respuesta;

    public GameController(GameModel modelo, GameGUI view, JeopardyModel jmodelo)
    {
        this.modelo = modelo;
        this.view = view;
        this.jmodel = jmodelo;

        this.view.P1.setText(jmodel.jugador1.getNombre() + " " + jmodel.jugador1.getPuntuacion());
        this.view.P2.setText(jmodel.jugador2.getNombre() + " " + jmodel.jugador2.getPuntuacion());

        for (JButton button : view.Scoreboard)
        {
            button.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent a)
    {
        modelo.getPosiciones(view.Catboard);

        for (JButton button : view.Scoreboard)
        {
            if (button == a.getSource())
            {
                try
                {
                    modelo.setPosicionescogido(button.getLocation());

                    categoria = modelo.getCategoria();

                    if (view.c > 19)
                    {
                        valor = Integer.parseInt(button.getText()) / 2;
                    } else
                    {
                        valor = Integer.parseInt(button.getText());
                    }

                    switch (valor)
                    {

                        case 100:
                            puntaje = 100;

                            pregunta = qmodel.getPregunta(categoria, puntaje);
                            opciones = qmodel.getOpciones(categoria, puntaje).split(",");
                            respuesta = qmodel.getRespuesta(categoria, puntaje);

                            startQuestion(pregunta, opciones, respuesta, puntaje, view, jmodel);

                            button.setEnabled(false);
                            view.setVisible(false);

                            break;
                        case 200:
                            puntaje = 200;

                            pregunta = qmodel.getPregunta(categoria, puntaje);
                            opciones = qmodel.getOpciones(categoria, puntaje).split(",");
                            respuesta = qmodel.getRespuesta(categoria, puntaje);

                            startQuestion(pregunta, opciones, respuesta, puntaje, view, jmodel);

                            button.setEnabled(false);
                            view.setVisible(false);

                            break;
                        case 300:
                            puntaje = 300;

                            pregunta = qmodel.getPregunta(categoria, puntaje);
                            opciones = qmodel.getOpciones(categoria, puntaje).split(",");
                            respuesta = qmodel.getRespuesta(categoria, puntaje);

                            startQuestion(pregunta, opciones, respuesta, puntaje, view, jmodel);

                            button.setEnabled(false);
                            view.setVisible(false);

                            break;
                        case 400:
                            puntaje = 400;

                            pregunta = qmodel.getPregunta(categoria, puntaje);
                            opciones = qmodel.getOpciones(categoria, puntaje).split(",");
                            respuesta = qmodel.getRespuesta(categoria, puntaje);

                            startQuestion(pregunta, opciones, respuesta, puntaje, view, jmodel);

                            button.setEnabled(false);
                            view.setVisible(false);

                            break;
                        case 500:
                            puntaje = 500;

                            pregunta = qmodel.getPregunta(categoria, puntaje);
                            opciones = qmodel.getOpciones(categoria, puntaje).split(",");
                            respuesta = qmodel.getRespuesta(categoria, puntaje);

                            startQuestion(pregunta, opciones, respuesta, puntaje, view, jmodel);

                            button.setEnabled(false);
                            view.setVisible(false);

                            break;
                    }
                    break;
                } catch (IOException ex)
                {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @SuppressWarnings("unused")
    public void startQuestion(String pregunta, String[] opciones, String respuesta, int puntaje, GameGUI gview, JeopardyModel jmodel) throws IOException
    {
        QuestionsGUI qview = new QuestionsGUI();
        QuestionsModel qmodelo = new QuestionsModel();
        JeopardyModel jmodelo = jmodel;
        QuestionsController controlador = new QuestionsController(qmodelo, qview, respuesta, puntaje, gview, jmodel);

        qview.statement.setText(pregunta);

        for (int i = 0; i < opciones.length; i++)
        {
            qview.ABC[i].setText(opciones[i]);
        }
    }
}
