/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugadores;

/**
 *
 * @author AAJ
 */
public class jugador
{

    public String nombre;
    public int puntuacion;
    public boolean su_turno;

    public jugador(String nombre, int puntuacion, boolean su_turno)
    {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.su_turno = su_turno;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getPuntuacion()
    {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion)
    {
        this.puntuacion = puntuacion;
    }

    public boolean isSu_turno()
    {
        return su_turno;
    }

    public void setSu_turno(boolean su_turno)
    {
        this.su_turno = su_turno;
    }
}
