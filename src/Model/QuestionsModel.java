/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author AAJ
 */
public class QuestionsModel
{

    public String textor, textoo, textop;
    public String[] listar, listao, listap;

    public QuestionsModel()
    {
    }

    public String getPregunta(String categoria, int puntaje) throws FileNotFoundException, IOException
    {
        String pregunta = "";

        FileReader frp = new FileReader("Preguntas.txt");
        BufferedReader brp = new BufferedReader(frp);

        while ((textop = brp.readLine()) != null)
        {
            listap = textop.split(",");

            if (Integer.parseInt(listap[0]) == puntaje && listap[1].equals(categoria))
            {
                pregunta = listap[2];
            }
        }
        brp.close();

        return pregunta;
    }

    public String getOpciones(String categoria, int puntaje) throws FileNotFoundException, IOException
    {
        String opciones = "";

        FileReader fro = new FileReader("Opciones.txt");
        BufferedReader bro = new BufferedReader(fro);

        while ((textoo = bro.readLine()) != null)
        {
            listao = textoo.split(",");

            if (Integer.parseInt(listao[0]) == puntaje && listao[1].equals(categoria))
            {
                opciones = listao[2] + "," + listao[3] + "," + listao[4];
            }
        }
        bro.close();

        return opciones;
    }

    public String getRespuesta(String categoria, int puntaje) throws FileNotFoundException, IOException
    {
        String respuesta = "";

        FileReader frr = new FileReader("Respuestas.txt");
        BufferedReader brr = new BufferedReader(frr);

        while ((textor = brr.readLine()) != null)
        {
            listar = textor.split(",");

            if (Integer.parseInt(listar[0]) == puntaje && listar[1].equals(categoria))
            {
                respuesta = listar[2];
            }
        }
        brr.close();

        return respuesta;
    }
}
