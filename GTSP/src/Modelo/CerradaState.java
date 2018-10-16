package Modelo;

import java.util.Date;

/**clase que usa el patron State para la tarea
 */
public class CerradaState implements IState
{
    Tarea tarea;

    /**finaliza el tiempo que tardo la tarea
     * @param tarea
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
