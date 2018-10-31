package Modelo;

import java.util.ArrayList;

/**Clase que usa State para el estado abierta de la tarea
 * <b>inv: </b><br>
 * tarea!=null <br>
 */
public class AbiertaState implements IState
{
    Tarea tarea;

    /**
     * @param tarea 
     * <b>pre:</b> tarea!=null.<br>
     * <b>post:</b> Se crea el estado.<br>
     */
    public AbiertaState(Tarea tarea)
    {
        this.tarea=tarea;
        this.verificaInvariante();
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

    /**Metodo que informa el estado de la tarea
     * @return String[] vector string con cada informacion solicitada por campo
     */
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
    
    public void verificaInvariante()
    {
        assert tarea!=null: "Referencia nula a tarea";
    }
}
