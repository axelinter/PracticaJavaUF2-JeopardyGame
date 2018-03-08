/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;
import javax.swing.JLabel;

/**
 *
 * @author AAJ
 */
public class GameModel
{

    public String categoria;
    public Point posicionescogido;
    public Point lit;
    public Point hit;
    public Point geo;
    public Point act;
    public Point ing;
    public Point mus;

    public String getCategoria()
    {
        if (posicionescogido.x == lit.x)
        {
            categoria = "Literatura";
        } else if (posicionescogido.x == hit.x)
        {
            categoria = "Historia";
        } else if (posicionescogido.x == geo.x)
        {
            categoria = "Geografia";
        } else if (posicionescogido.x == act.x)
        {
            categoria = "Actualidad";
        } else if (posicionescogido.x == ing.x)
        {
            categoria = "Ingles";
        } else if (posicionescogido.x == mus.x)
        {
            categoria = "Musica";
        }

        return categoria;
    }

    public void getPosiciones(JLabel[] catboard)
    {
        JLabel[] componentes = catboard;
        for (int i = 0; i < componentes.length; i++)
        {
            switch (componentes[i].getText())
            {
                case "Literatura":
                    this.setLit(componentes[i].getLocation());
                    break;
                case "Historia":
                    this.setHit(componentes[i].getLocation());
                    break;
                case "Geografia":
                    this.setGeo(componentes[i].getLocation());
                    break;
                case "Actualidad":
                    this.setAct(componentes[i].getLocation());
                    break;
                case "Ingles":
                    this.setIng(componentes[i].getLocation());
                    break;
                case "Musica":
                    this.setMus(componentes[i].getLocation());
                    break;
            }
        }
    }

    public void setPosicionescogido(Point posicionescogido)
    {
        this.posicionescogido = posicionescogido;
    }

    public void setLit(Point lit)
    {
        this.lit = lit;
    }

    public void setHit(Point hit)
    {
        this.hit = hit;
    }

    public void setGeo(Point geo)
    {
        this.geo = geo;
    }

    public void setAct(Point act)
    {
        this.act = act;
    }

    public void setIng(Point ing)
    {
        this.ing = ing;
    }

    public void setMus(Point mus)
    {
        this.mus = mus;
    }
}
