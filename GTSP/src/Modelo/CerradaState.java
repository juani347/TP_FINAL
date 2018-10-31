package Modelo;

import java.util.Date;

/**Clase que usa State para el estado cerrada de la tarea
 * <b>inv: </b><br>
 * tarea!=null <br>
 */
public class CerradaState implements IState
{
    Tarea tarea;

    /**
     * @param tarea
     * <b>pre:</b> tarea!=null.<br>
     * <b>post:</b> Se crea el estado y se setea la fecha de cierre de la tarea.<br>
     */
    public CerradaState(Tarea tarea)
    {
        this.tarea=tarea;
        this.tarea.setFechaCierre(new Date());
        if(this.tarea.getServicio().getDescripcion().equalsIgnoreCase(Servicio.XHORA))
        {
            double horas=((this.tarea.getFechaCierre().getTime()-this.tarea.getFechaInicio().getTime())/1000)/3600;
            this.tarea.setCostoTotal(horas*this.tarea.getServicio().getCosto());
        }
        else
            this.tarea.setCostoTotal(this.tarea.getServicio().getCosto());
        this.verificaInvariante();
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
    
    public void verificaInvariante()
    {
        assert tarea!=null: "Referencia nula a tarea";
    }
}
