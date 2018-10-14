package Modelo;


/**Clase que usa State para la tarea se encarga de pausarla
 */
public class PausadaState implements IState
{
    Tarea tarea;

    /**metodo que pausa la tarea
     * @param tarea
     */
    public PausadaState(Tarea tarea)
    {
        this.tarea=tarea;
    }

    /**metodo que continua la tarea
     */
    @Override
    public void abrir()
    {
        this.tarea.setEstado(new AbiertaState(this.tarea));
    }

    /**metodo que cierra la tarea
     */
    @Override
    public void cerrar()
    {
        this.tarea.setEstado(new CerradaState(this.tarea));
    }

    @Override
    public void pausar(){}
    
    @Override
    public String toString()
    {
        return "Pausada";
    }

    /**Metodo que informa estado de la tarea
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
}
