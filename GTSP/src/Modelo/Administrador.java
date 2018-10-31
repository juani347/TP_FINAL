package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/** Clase tipo de usuario que administra el funcionamiento
 */
public class Administrador extends Usuario
{
    
    public Administrador(String nombreApe, String email, String telefono, String perfil, String nombreUsuario, String contraseña, BaseDeDatos base)
    {
        super(nombreApe, email,telefono,perfil,nombreUsuario,contraseña,base);
    }
    
    public Administrador(){}

    /**Metodo que agrega un nuevo Usario a la base de datos
     * @param nombreApe Nombre y apellido del Usuario agregado
     * @param email Email del Usuario agregado
     * @param telefono Telefono del Usuario agregado
     * @param nombreUsuario Nombre de usuario para el logeo
     * @param contraseña Contraseña del usuario para el logeo
     * @param base Base de datos donde se va a cargar el usuario
     * @throws GeneralException se lanza cuando el nombre de usuario ya existia en nuestra base de datos
     * <b>pre:</b> La base de datos puede poseer o no un usuario con ese nombre.<br>
     * Todos los parametros deben ser distintos de null y distintos de vacio.<br>
     * <b>post:</b> Se agrego un usuario si no existia uno con ese nombre de usuario.<br>
     */
    public void agregarUsuario(String nombreApe, String email, String telefono, String nombreUsuario, String contraseña,BaseDeDatos base) throws GeneralException
    {
        if (this.base.getListaUsuarios().containsKey(nombreUsuario))
            throw new GeneralException("Nombre de usuario ya existente");
        else
            this.base.getListaUsuarios().put(nombreUsuario,new Colaborador(nombreApe,email,telefono,"colaborador",nombreUsuario,contraseña,base));
    }

    /** Metodo que elimina un usuario de la base de datos si existe en ella
     * @param nombreUsuario Nombre del usuario que se va a eliminar
     * <b>pre:</b>El usuario esta en el programa.<br>
     * nombreUsuario != null && !equals("")<br>
     * <b>post:</b> Se elimina al participante del programa.<br>
     */
    public void eliminarUsuario(String nombreUsuario)
    {
        if (this.base.getListaUsuarios().containsKey(nombreUsuario))
            this.base.getListaUsuarios().remove(nombreUsuario);
    }

    /** Metodo que elimina un tarea
     * @param tarea
     * <b>pre:</b>La tarea debe estar en la base de datos.<br>
     * tarea != null<br>
     * <b>post:</b> Se elimina al participante de la base de datos.<br>
     */
    public void eliminarTarea(Tarea tarea)
    {
        this.base.getTareas().remove(tarea);
    }

    /**Metodo que agrega un grupo a la base de datos
     * @param nombre nombre del grupo
     * @param ID indentificador del grupo
     * @throws GeneralException cuando se intenta crear un grupo con una id que ya existia
     * <b>pre:</b>No importa si hay o no grupos anteriores.<br>
     * nombre != null && !equals("")<br>
     * ID >=0<br>
     * <b>post:</b>Se agrega un grupo si la id no existia anteriormente.<br>
     */
    public void agregarGrupo(String nombre, int ID) throws GeneralException
    {
        if (this.base.getGrupos().containsKey(ID))
            throw new GeneralException("Grupo de cliente ya existente");
        this.base.getGrupos().put(ID,new Grupo_de_Clientes(nombre,ID));
    }

    /**metodo que elimina un grupo
     * @param grupo que se desea eliminar
     * <b>pre:</b>
     * grupo!=null<br>
     * <b>post:</b>Se elimina elimino el grupo si la id existia.<br>
     */
    public void eliminarGrupo(Grupo_de_Clientes grupo)
    {
        this.base.getGrupos().remove(grupo);
    }

    /**Agrega un servicio a la base de datos
     * @param descripcion del servicio
     * @param tipo de servicio que realiza el colaborador
     * @param costo que se cotizara
     * @throws GeneralException cuando la descripcion del servicio ya existia
     * <b>pre:</b>No importa si hay o no servicios anteriores<br>
     * descrpcion!=null && !equals("")<br>
     * tipo!=null && !equals("")<br>
     * costo>0<br>
     * <b>post:</b>Agrega un servicio si la descripcion no exisita anteriormente<br>
     */
    public void agregarServicio(String descripcion, String tipo, double costo) throws GeneralException
    {
        if (this.base.getServicios().containsKey(descripcion))
            throw new GeneralException("Servicio ya existente");
        else
            this.base.getServicios().put(descripcion, new Servicio(descripcion,tipo,costo));
    }

    /**Metodo que elimina un servicio
     * @param descripcion del servicio q se desea borrar
     * @throws GeneralException cuando la descripcion del servicio no correspondia con ninguno en la base de datos
     * <b>pre:</b>La descripcion puede existir o no<br>
     * descrpcion!=null && !equals("")<br>
     * <b>post:</b>Se elimina el servicio si existia esa descripcion.<br>
     */
    public void eliminarServicio(String descripcion) throws GeneralException
    {
        if (this.base.getServicios().containsKey(descripcion))
            this.base.getServicios().remove(descripcion);
        else
            throw new GeneralException("No existe el servicio");
    }

    /**metodo que agrega un cliente
     * @param nombreApe nombre y apellido del cliente
     * @param email del cliente
     * @param telefono del cliente
     * @param CUIT del cliente
     * @param razonSocial del cliente
     * @param grupoClientes id que indentifica al grupo
     * @throws GeneralException cuando el nombreApe ya estaba registrado en la base de datos
     * <b>pre:</b>No importa si habia clientes anteriormente o no.<br>
     * Todos los parametros deben ser distintos de null y distintos de vacio.<br>
     * <b>post:</b>Agrega un cliente si este tiene un nombreApe distinto a los de la base de datos<br>
     */
    public void agregarCliente(String nombreApe, String email, String telefono, String CUIT, String razonSocial,String grupoClientes) throws GeneralException
    {
        if (this.base.getClientes().containsKey(nombreApe))
            throw new GeneralException("Cliente ya registrado");
        else
            this.base.getClientes().put(nombreApe, new Cliente(nombreApe,email,telefono,CUIT,razonSocial,grupoClientes));
    }

    /**Metodo que elimina un cliente
     * @param nombreApe nombre de cliente que se sea borrar
     * @throws GeneralException cuando el nombre del cliente no existia en la base de datos
     * <b>pre:</b>El nombre del cliente puede existir o no.<br>
     * nombreApe!=null && !equals("")<br>
     * <b>post:</b>Se elimina el cliente solo si el nombre existia.<br>
     */
    public void eliminarCliente(String nombreApe) throws GeneralException
    {
        if (this.base.getClientes().containsKey(nombreApe))
            this.base.getClientes().remove(nombreApe);
        else
            throw new GeneralException("No existe el cliente");
    }

    /**Metodo que hace informe de estado de las tareas
     * @param colaborador nombre del colaborador cuyas tareas se informaran o "todos" para referirse al total de colaboradores <br>
     * @return un Arraylist de String sobre las tareas
     * <b>pre:</b>Puede haber tareas en la base de datos o no<br>
     * colaborador!=null && !equals("")<br>
     * <b>post:</b>Devuelve un informe sobre sus tareas.<br>
     */
    public ArrayList<String[]> informeEstadoTareas(String colaborador)
    {
        ArrayList<String[]> informe=new ArrayList<String[]>();
        String[] aux;
        Iterator<Tarea> it= this.base.getTareas().iterator();
        if (colaborador.equalsIgnoreCase("todos"))
        {
            while (it.hasNext())
            {
                aux= it.next().getInforme();
                if (aux!=null)
                    informe.add(aux);
            }
        }
        else
        {
            while (it.hasNext())
            {
                Tarea tarea=it.next();
                if (tarea.getColaborador().equals(colaborador))
                {
                    aux= tarea.getInforme();
                    if (aux!=null)
                        informe.add(aux);
                }
            }
        }
        return informe;
    }

    /**Metodo que informa las tareas realizadas dentro de un periodo para un cliente
     * @param nombre nombre del cliente
     * @param inicio inicio del periodo 
     * @param fin valor final del perido
     * <b>pre:</b>El cliente debe existir en la base de datos<br>
     * nombre!=null && !equals("")<br>
     * inicio!=null<br>
     * fin!=null<br>
     * <b>post:</b>Le pasa un String del informe al observador.<br>
     */
    public void informeTareasPeriodo(String nombre,Date inicio,Date fin)
    {   
        long horas,tot=0;
        String res="Tarea de Servicio   Total Horas   Importe\n";
        Cliente cliente=this.base.getClientes().get(nombre);
        Iterator<Tarea> it=base.getIteratorTarea();
        while(it.hasNext())
        {
            Tarea t=it.next();
            if(t.getCliente().equals(cliente)&&(t.getFechaInicio().after(inicio)&&t.getFechaInicio().before(fin)))
            {
                if (t.getFechaCierre()==null)
                    horas=((new Date().getTime() - t.getFechaInicio().getTime())/1000)/3600;
                else
                    horas=((t.getFechaCierre().getTime() - t.getFechaInicio().getTime())/1000)/3600;
                tot+=t.getCostoTotal();
                res+=t.getServicio().getDescripcion()+"   "+horas+"   "+t.getCostoTotal()+"\n";
            }
        }
        res+="IMPORTE TOTAL: $"+tot;
        this.setChanged();
        this.notifyObservers(res);
    }

    /**Metodo que informara las tareas de un colaborador dedicadas a los clientes
     * @param colaborador nombre del colaborador
     * @param inicio inicio del periodo
     * @param fin del periodo
     * <b>pre:</b>El nombre del colaborador debe corresponder con un colaborador en la base de datos<br>
     * colaborador!=null && !equals("")<br>
     * inicio!=null<br>
     * fin!=null<br>
     * <b>post:</b>Se informara un string al observador<br>
     */
    public void informeTareasColaborador(String colaborador,Date inicio,Date fin)
    {
        String res="Cliente   Tarea de Servicio   Total Horas\n";
        Colaborador col=(Colaborador)this.base.getListaUsuarios().get(colaborador);
        Iterator<Tarea> it=col.getTareas().values().iterator();
        long horas,tot=0;
        Tarea aux;
        while(it.hasNext())
        {
            aux=it.next();
            if(aux.getFechaInicio().after(inicio)&&aux.getFechaInicio().before(fin))
            {
                if (aux.getFechaCierre()==null)
                    horas=((new Date().getTime() - aux.getFechaInicio().getTime())/1000)/3600;
                else
                    horas=((aux.getFechaCierre().getTime()-aux.getFechaInicio().getTime())/1000)/3600;
                tot+=horas;
                res+=aux.getCliente()+"   "+aux.getServicio()+"   "+horas+"\n";   
            }
        }
        res+="TOTAL HORAS: "+tot+"hs";
        this.setChanged();
        this.notifyObservers(res);
    }

    /**metodo que informa tareas realizadas o en curso por un usuario
     * @param usuario
     * @param estado
     * @param inicio
     * @param fin
     * <b>pre:</b>El nombre de usuario debe corresponder con un colaborador en la base de datos<br>
     * usuario!=null && !equals("")<br>
     * estado!=null && !equals("")<br>
     * inicio!=null<br>
     * fin!=null<br>
     * <b>post:</b>Se informara un string al observador<br>
     */
    public void informeTareasUsuario(String usuario,String estado,Date inicio,Date fin)
    {
        String res="Cliente   Tarea de Servicio   Inicio   Estado   Horas Acumuladas\n";
        Usuario user=this.base.getListaUsuarios().get(usuario);
        Iterator<Tarea> it=this.base.getIteratorTarea();
        Tarea aux;
        DateFormat dataux;
        long horas;
        while(it.hasNext())
        {
            aux=it.next();
            if(aux.getColaborador().equals(user))
                if(estado.equalsIgnoreCase("Todos")||estado.equalsIgnoreCase(aux.toString()))
                {
                    dataux=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                    if (aux.getFechaCierre()==null)
                        horas=((new Date().getTime() - aux.getFechaInicio().getTime())/1000)/3600;
                    else
                        horas=((aux.getFechaCierre().getTime()-aux.getFechaInicio().getTime())/1000)/3600;
                    if(aux.getFechaInicio().after(inicio)&&aux.getFechaInicio().before(fin))
                        res+=aux.getCliente()+"   "+aux.getServicio().getDescripcion()+"   "+dataux.format(inicio)+"   "+aux.getEstado().toString()+"   "+horas+"\n";
                }
        }
        this.setChanged();
        this.notifyObservers(res);
    }
}
