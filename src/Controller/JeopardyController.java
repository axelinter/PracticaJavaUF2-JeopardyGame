/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Jugadores.jugador;
import Model.GameModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import Model.JeopardyModel;
import View.GameGUI;
import View.JeopardyGUI;

/**
 *
 * @author AAJ
 */
public class JeopardyController implements ActionListener
{

    private JeopardyModel modelo;
    private JeopardyGUI view;

    public JeopardyController(JeopardyModel modelo, JeopardyGUI view)
    {
        this.modelo = modelo;
        this.view = view;

        for (JButton button : view.botones)
        {
            button.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (JButton button : view.botones)
        {
            if (button == e.getSource())
            {
                if (button.getText().equals("JUGAR"))
                {
                    jugador jugador1 = new jugador(view.nombre_jugador1.getText(), 0, true);
                    jugador jugador2 = new jugador(view.nombre_jugador2.getText(), 0, false);
                    modelo.setJugador1(jugador1);
                    modelo.setJugador2(jugador2);
                    this.startGame();
                    view.dispose();
                } else
                {
                    view.dispose();
                }
            }
        }
    }

    @SuppressWarnings("unused")
    public void startGame()
    {
        GameGUI gview = new GameGUI();
        GameModel gmodelo = new GameModel();
        GameController controlador = new GameController(gmodelo, gview, modelo);
    }
}
