package Modelo;

import java.util.HashMap;
import java.util.Iterator;

/**Clase que se encarga de hacer tareas al Cliente
 */
public class Colaborador extends Usuario
{
    private HashMap<Integer,Tarea> tareas=new HashMap<Integer,Tarea>();
    
    public Colaborador(String nombreApe, String email, String telefono, String perfil, String nombreUsuario, String contraseña, BaseDeDatos base)
    {
        super(nombreApe, email,telefono,"Colaborador",nombreUsuario,contraseña,base);
    }


    public Colaborador()
    {
        super();
    }

    /**Metodo que agrega una tarea
     * @param ID de la tarea
     * @param cliente a quien se le realiza
     * @param servicio elegido para la tarea
     * @throws GeneralException cuando el colaborador se encuentra haciendo una tarea en este momento
     * <b>pre:</b> ID>=0<br>
     * cliente!=null<br>
     * servicio!=null<br>
     */
    public void agregarTarea(int ID,Cliente cliente,Servicio servicio) throws GeneralException
    {
        if (this.ningunaAbierta())
        {
            Tarea t=new Tarea(this,cliente,servicio);
            this.base.getTareas().add(t);
            this.tareas.put(ID, t);
        }
        else
            throw new GeneralException("Hay tareas abiertas");
    }

    /**metodo que continua con la tarea
     * @param ID de la tarea
     * <b>pre:</b> ID>=0.<br>
     */
    public void abrirTarea(int ID)
    {
        if (this.ningunaAbierta())
            tareas.get(ID).getEstado().abrir();
    }
    
    public void pausarTarea(int ID)
    {
        tareas.get(ID).getEstado().pausar();
    }
    
    public void cerrarTarea(int ID)
    {
        tareas.get(ID).getEstado().cerrar();
    }
    
    /**
     * @param tareas
     * <b>pre:</b> tareas!=null
     */
    public void setTareas(HashMap<Integer, Tarea> tareas)
    {
        this.tareas = tareas;
    }

    public HashMap<Integer, Tarea> getTareas()
    {
        return tareas;
    }

    /**Metodo que verifica que no haya tareas abiertas
     * @return true o false
     */
    private boolean ningunaAbierta()
    {
        boolean ok=true;
        Iterator<Tarea> it=tareas.values().iterator();
        while (it.hasNext() && ok)
        {
            if (it.next().toString().equals("Abierta"))
                ok=false;
        }
        return ok;
    }
}
