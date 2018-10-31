package Modelo;

/**Clase que usa State para el estado pausada de la tarea
 * <b>inv: </b><br>
 * tarea!=null <br>
 */
public class PausadaState implements IState
{
    Tarea tarea;

    /**
     * @param tarea
     * <b>pre:</b> tarea!=null.<br>
     * <b>post:</b> Se crea el estado.<br>
     */
    public PausadaState(Tarea tarea)
    {
        this.tarea=tarea;
        this.verificaInvariante();
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
    
    
    public void verificaInvariante()
    {
        assert tarea!=null: "Referencia nula a tarea";
    }
}
