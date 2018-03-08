/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author AAJ
 */
public class JeopardyGUI extends JFrame
{

    private static final long serialVersionUID = 3911459989765690986L;

    public JButton jugar;
    public JButton salir;
    public JButton[] botones;
    public JLabel label;
    public ImageIcon image;
    public Image imagenFondo;
    public URL url;
    public TextField nombre_jugador1;
    public TextField nombre_jugador2;
    public JLabel jugador1;
    public JLabel jugador2;

    public JeopardyGUI()
    {
        this.setSize(new Dimension(800, 500));
        this.setVisible(true);
        this.setTitle("Jeopardy");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        try
        {
            URL url = new File("img/Jeopardy.jpg").toURI().toURL();

            try
            {
                this.imagenFondo = ImageIO.read(url);
                Image resizedImage = imagenFondo.getScaledInstance(800, 500, 0);
                this.image = new ImageIcon(resizedImage);
                this.label = new JLabel(this.image);

                this.setLayout(new BorderLayout());

                try
                {
                    this.add(this.label);

                    JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
                    JPanel jugadores = new JPanel(new GridLayout(1, 2));

                    try
                    {
                        this.label.setLayout(new BorderLayout());

                        jugador1 = new JLabel("Nombre jugador1: ");
                        jugador2 = new JLabel("Nombre jugador2: ");
                        nombre_jugador1 = new TextField();
                        nombre_jugador2 = new TextField();

                        jugadores.add(jugador1);
                        jugadores.add(nombre_jugador1);
                        jugadores.add(jugador2);
                        jugadores.add(nombre_jugador2);

                        String[] jugar_salir =
                        {
                            "JUGAR", "SALIR"
                        };

                        botones = new JButton[jugar_salir.length];

                        for (int i = 0; i < jugar_salir.length; i++)
                        {
                            botones[i] = new JButton(jugar_salir[i]);
                            botones[i].setFont(new Font("Consolas", Font.PLAIN, 20));
                            botones[i].setMargin(new Insets(10, 10, 10, 10));
                            buttonsPanel.add(botones[i]);
                        }

                        try
                        {
                            this.label.add(jugadores, BorderLayout.NORTH);
                            this.label.add(buttonsPanel, BorderLayout.SOUTH);

                            this.pack();
                        } catch (NullPointerException ef)
                        {
                            System.err.println("La variable URL ha sido declarada pero no apunta a ningun objeto, probablemente la ruta es incorrecta.");
                        }
                    } catch (NullPointerException ef)
                    {
                        System.err.println("No se ha podido añadir el borderlayout del label, el objeto está inicializado pero es null.");
                    }
                } catch (NullPointerException ef)
                {
                    System.err.println("No se ha podido añadir el fondo al panel, el objeto está inicializado pero es null.");
                }
            } catch (IOException ex)
            {
                System.err.println("No se ha podido encontrar la imagen de fondo");
            } catch (IllegalArgumentException e)
            {
                System.err.println("Argumento inválido");
            }
        } catch (MalformedURLException ex)
        {
            System.err.println("URL incorrecta");
        }
    }
}
