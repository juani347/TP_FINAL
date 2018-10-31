package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**Clase base de datos que se encarga de tener todos los datos el programa
 * <b>inv:</b><br>
 * listaUsuarios!=null
 * clientes!=null
 * grupos!=null
 * servicios!=null
 * tareas!=null
 * admin!=null
 */
public class BaseDeDatos
{
    private HashMap<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();
    private HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
    private HashMap<Integer, Grupo_de_Clientes> grupos = new HashMap<Integer, Grupo_de_Clientes>();
    private HashMap<String, Servicio> servicios = new HashMap<String, Servicio>();
    private ArrayList<Tarea> tareas = new ArrayList<Tarea>();
    private Administrador admin;

    public BaseDeDatos()
    {
        super();
        this.admin = new Administrador("Admin", "admin@gmail.com", "1234567", "Admisitrador", "admin", "1234", this);
        this.verificarInvariante();
    }

    /** Método que da los una lista de los nombres user de los usuarios
     * @return los nombres de los usuarios en cada campo
     */
    public String[] darListausarios()
    {

        String[] nombres;
        if (this.listaUsuarios.size() != 0)
        {
            nombres = new String[this.listaUsuarios.size()];
            int i = 0;
            Iterator it = this.listaUsuarios
                              .keySet()
                              .iterator();
            while (it.hasNext())
            {
                String aux = (String) it.next();
                nombres[i] = aux;
                i++;
            }
        } else
            nombres = null;
        return nombres;
    }

    /**Método que da los nombres de los clientes
     * @return los nombres de los cliente en cada campo
     */
    public String[] darClientes()
    {
        String[] nombres;
        if (this.clientes.size() != 0)
        {
            nombres = new String[this.clientes.size()];
            int i = 0;
            Iterator it = this.clientes
                              .keySet()
                              .iterator();
            while (it.hasNext())
            {
                String aux = (String) it.next();
                nombres[i] = aux;
                i++;
            }
        } else
            nombres = null;
        return nombres;
    }

    /**Método que corrobora si tus datos son los del admin
     * @param nombreUsuario user de usuario
     * @param pass contraseña 
     * @return el admin o nulo
     * <b>pre:</b>
     * nombreUsuario!=null && !equals("")<br>
     * pass!=null && !equals("")<br>
     */
    public Administrador esAdmin(String nombreUsuario, String pass)
    {
        Administrador resp = null;
        if ((this.admin
                 .getNombreUsuario()
                 .equals(nombreUsuario) && this.admin
                                               .getContraseña()
                                               .equals(pass)))
            resp = this.admin;
        return resp;
    }

    /**elimina un grupo
     * @param i id del grupo
     * <b>pre:</b>
     * i>=0<br>
     */
    public void deleteGRupo(int i)
    {
        this.grupos.remove(i);
    }
    
    /**
     * @param listaUsuarios!=null
     */
    public void setListaUsuarios(HashMap<String, Usuario> listaUsuarios)
    {
        this.listaUsuarios = listaUsuarios;
        this.verificarInvariante();
    }
    
    public HashMap<String, Usuario> getListaUsuarios()
    {
        return listaUsuarios;
    }

    /**
     * @param clientes
     * <b>pre:</b>clientes!=null
     */
    public void setClientes(HashMap<String, Cliente> clientes)
    {
        this.clientes = clientes;
        this.verificarInvariante();
    }

    public HashMap<String, Cliente> getClientes()
    {
        return clientes;
    }
    
    /**
     * @param servicios
     * <b>pre:</b> servicios!=null
     */
    public void setServicios(HashMap<String, Servicio> servicios)
    {
        this.servicios = servicios;
        this.verificarInvariante();
    }

    public HashMap<String, Servicio> getServicios()
    {
        return servicios;
    }

    /**
     * @param tareas
     * <b>pre:</b> tareas!=null
     */
    public void setTareas(ArrayList<Tarea> tareas)
    {
        this.tareas = tareas;
        this.verificarInvariante();
    }

    public ArrayList<Tarea> getTareas()
    {
        return tareas;
    }
    
    /**
     * @param grupos
     * <b>pre:</b> grupos!=null
     */
    public void setGrupos(HashMap<Integer, Grupo_de_Clientes> grupos)
    {
        this.grupos = grupos;
        this.verificarInvariante();
    }

    public HashMap<Integer, Grupo_de_Clientes> getGrupos()
    {
        return grupos;
    }

    public void agregarUsuario(Usuario usuario)
    {
        this.listaUsuarios.put(usuario.getNombreUsuario(), usuario);
    }

    public Iterator<Tarea> getIteratorTarea()
    {
        return this.tareas.iterator();
    }

    /**
     * @param admin
     * <b>pre:</b> admin!=nul
     */
    public void setAdmin(Administrador admin)
    {
        this.admin = admin;
        this.verificarInvariante();
    }

    public Administrador getAdmin()
    {
        return admin;
    }
    
    private void verificarInvariante()
    {
        assert listaUsuarios!=null : "La lista de usuarios es nula";
        assert clientes!=null : "El HashMap de clientes es nulo";
        assert grupos!=null : "El HashMap de los grupos de clientes es nulo";
        assert servicios!=null : "El HashMap de los servicios es nulo";
        assert tareas!=null : "El HashMap de las tareas es nulo";
        assert admin!=null : "El admin es nulo";
    }
}
