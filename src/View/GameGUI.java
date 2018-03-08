/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GameController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author AAJ
 */
public class GameGUI extends JFrame
{

    private static final long serialVersionUID = 457523076346814664L;

    public GameController controller;

    public JLabel[] Catboard;
    public JButton[] Scoreboard;

    public String[] cat =
    {
        "Literatura", "Historia", "Geografia", "Actualidad", "Ingles", "Musica"
    };
    public int[] scores =
    {
        100, 100, 100, 100, 100, 100, 200, 200, 200, 200, 200, 200, 300, 300, 300, 300, 300, 300, 400, 400, 400, 400, 400, 400, 500, 500, 500, 500, 500, 500
    };

    public int score1 = 0;
    public int score2 = 0;

    public int c = 0;

    Border b = BorderFactory.createLineBorder(Color.BLACK, 5);
    Border margin = BorderFactory.createLineBorder(Color.blue, 10);

    public JPanel Player1 = new JPanel();
    public JPanel Player2 = new JPanel();
    public JLabel P1 = new JLabel();
    public JLabel P2 = new JLabel();

    public GameGUI()
    {
        this.setTitle("Tablero");
        agregarContenido(this.getContentPane());
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void agregarContenido(Container pane)
    {
        JPanel Categories = new JPanel(new GridLayout(1, 6));
        JPanel Questions = new JPanel(new GridLayout(5, 6));

        Catboard = new JLabel[cat.length];
        Scoreboard = new JButton[scores.length];

        for (int i = 0; i < cat.length; i++)
        {
            Catboard[i] = new JLabel(cat[i], SwingConstants.CENTER);
            Catboard[i].setPreferredSize(new Dimension(150, 100));
            Catboard[i].setFont(new Font("Consolas", Font.PLAIN, 20));
            Catboard[i].setBorder(b);
            Catboard[i].setOpaque(true);
            Catboard[i].setBackground(Color.gray);
            Catboard[i].setForeground(Color.blue);
            Categories.add(Catboard[i]);
            Categories.setBorder(margin);
        }

        for (int i = 0; i < scores.length; i++)
        {
            Scoreboard[i] = new JButton(String.valueOf(scores[i]));
            Scoreboard[i].setPreferredSize(new Dimension(150, 100));
            Scoreboard[i].setFont(new Font("Consolas", Font.PLAIN, 40));
            Scoreboard[i].setBorder(b);
            Scoreboard[i].setBackground(Color.gray);
            Scoreboard[i].setForeground(Color.blue);
            Questions.add(Scoreboard[i]);
            Questions.setBorder(margin);
        }

        P1.setOpaque(true);
        P1.setPreferredSize(new Dimension(400, 100));
        P1.setBorder(b);
        P1.setBackground(Color.gray);
        P1.setFont(new Font("Consolas", Font.PLAIN, 45));
        P1.setForeground(Color.blue);

        P2.setOpaque(true);
        P2.setPreferredSize(new Dimension(400, 100));
        P2.setBorder(b);
        P2.setBackground(Color.gray);
        P2.setFont(new Font("Consolas", Font.PLAIN, 45));
        P2.setForeground(Color.blue);

        Player1.add(P1);
        Player2.add(P2);

        pane.add(Categories, BorderLayout.NORTH);
        pane.add(Questions, BorderLayout.SOUTH);
        pane.add(Player1, BorderLayout.WEST);
        pane.add(Player2, BorderLayout.EAST);
        pane.setBackground(Color.DARK_GRAY);
    }
}
