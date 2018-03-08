/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeopardy;

import Controller.JeopardyController;
import java.io.IOException;
import Model.JeopardyModel;
import View.JeopardyGUI;

/**
 *
 * @author AAJ
 */
public class Jeopardy
{

    public static void main(String[] args) throws InterruptedException, IOException
    {
        JeopardyGUI view = new JeopardyGUI();
        JeopardyModel modelo = new JeopardyModel();

        try
        {
            @SuppressWarnings("unused")
            JeopardyController controller = new JeopardyController(modelo, view);
        } catch (NullPointerException e)
        {
            System.err.println("El controlador no ha podido ser inicializado correctamente");
        }
    }
}
