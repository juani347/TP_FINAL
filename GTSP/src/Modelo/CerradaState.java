package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class CerradaState implements IState
{
    Tarea tarea;
    
    public CerradaState(Tarea tarea)
    {
        this.tarea=tarea;
        this.tarea.setFechaCierre(new Date());
    }

    @Override
    public void abrir(){}

    @Override
    public void cerrar(){}

    @Override
    public void pausar(){}
    
    @Override
    public String toString()
    {
        return "Cerrada";
    }
    
    @Override
    public String[] getInforme()
    {
        return null;
    }
}
