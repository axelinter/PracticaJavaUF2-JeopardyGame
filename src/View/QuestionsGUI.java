/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class QuestionsGUI extends JFrame
{

    private static final long serialVersionUID = 6284417290067036387L;

    public JPanel Question = new JPanel();
    public JPanel Options = new JPanel(new GridLayout(3, 1));

    public String[] opciones = new String[3];
    public JButton[] ABC = new JButton[opciones.length];
    ;
    public JLabel statement = new JLabel();

    public Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
    public Border margin = BorderFactory.createLineBorder(Color.ORANGE, 10);

    public QuestionsGUI() throws IOException
    {
        this.setTitle("Pregunta");
        agregarContenido(this.getContentPane());
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void agregarContenido(Container pane) throws FileNotFoundException, IOException
    {
        statement.setVerticalAlignment(SwingConstants.CENTER);
        statement.setHorizontalAlignment(SwingConstants.CENTER);
        statement.setPreferredSize(new Dimension(500, 200));
        statement.setFont(new Font("Consolas", Font.PLAIN, 40));
        statement.setBorder(border);
        statement.setOpaque(true);
        statement.setBackground(Color.gray);
        statement.setForeground(Color.yellow);
        Question.add(statement);

        for (int i = 0; i < opciones.length; i++)
        {
            ABC[i] = new JButton(String.valueOf(opciones[i]));
            ABC[i].setPreferredSize(new Dimension(150, 100));
            ABC[i].setFont(new Font("Consolas", Font.PLAIN, 40));
            ABC[i].setBorder(border);
            ABC[i].setBackground(Color.gray);
            ABC[i].setForeground(Color.yellow);
            Options.add(ABC[i]);
            Options.setBorder(margin);
        }

        pane.add(Question, BorderLayout.NORTH);
        pane.add(Options, BorderLayout.SOUTH);
        pane.setBackground(Color.DARK_GRAY);
    }
}
