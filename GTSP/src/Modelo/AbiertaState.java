package Modelo;

import java.util.ArrayList;

public class AbiertaState implements IState
{
    Tarea tarea;
    
    public AbiertaState(Tarea tarea)
    {
        this.tarea=tarea;
    }

    @Override
    public void abrir(){}

    @Override
    public void cerrar()
    {
        this.tarea.setEstado(new CerradaState(this.tarea));
    }

    @Override
    public void pausar()
    {
        this.tarea.setEstado(new PausadaState(this.tarea));
    }
    
    @Override
    public String toString()
    {
        return "Abierta";
    }
    
    @Override
    public String[] getInforme()
    {
        String informe[]=new String[6];
        informe[0]= tarea.getColaborador().getNombreApe();
        informe[1]=tarea.getCliente().getNombreApe();
        informe[2]=tarea.getServicio().getDescripcion();
        informe[3]=tarea.getFechaInicio().toString();
        informe[4]=tarea.getEstado().toString();
        informe[5]=tarea.getHoras().toString();
        return informe;
    }
}
