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
