package Modelo;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Administrador extends Usuario
{
    
    public Administrador(String string, String string1, String string2, String string3, String string4, String string5, BaseDeDatos base)
    {
        super(string, string1, string2, string3, string4, string5,base);
    }
    
    public Administrador(){}

    public void agregarUsuario(String nombreApe, String email, String telefono, String nombreUsuario, String contraseña,BaseDeDatos base) throws OtraException
    {
        if (this.base.getListaUsuarios().containsKey(nombreUsuario))
            throw new OtraException("Nombre de usuario ya existente");
        else
            this.base.getListaUsuarios().put(nombreUsuario,new Colaborador(nombreApe,email,telefono,nombreUsuario,contraseña,base));
    }
    
    public void eliminarUsuario(String nombreUsuario)
    {
        if (this.base.getListaUsuarios().containsKey(nombreUsuario))
            this.base.getListaUsuarios().remove(nombreUsuario);
    }
    
    /* public void agregarTarea(Colaborador colaborador, Cliente cliente,Servicio servicio)
    {
        this.base.getTareas().add(new Tarea(colaborador,cliente,servicio));
    } */
    
    public void eliminarTarea(Tarea tarea)
    {
        this.base.getTareas().remove(tarea);
    }
    
    public void agregarGrupo(String nombre, int ID) throws OtraException
    {
        if (this.base.getGrupos().containsKey(ID))
            throw new OtraException("Grupo de cliente ya existente");
        this.base.getGrupos().put(ID,new Grupo_de_Clientes(nombre,ID));
    }
    
    public void eliminarGrupo(Grupo_de_Clientes grupo)
    {
        this.base.getGrupos().remove(grupo);
    }
    
    public void agregarServicio(String descripcion, String tipo, double costo) throws OtraException
    {
        if (this.base.getServicios().containsKey(descripcion))
            throw new OtraException("Servicio ya existente");
        else
            this.base.getServicios().put(descripcion, new Servicio(descripcion,tipo,costo));
    }
    
    public void eliminarServicio(String descripcion) throws OtraException
    {
        if (this.base.getServicios().containsKey(descripcion))
            this.base.getServicios().remove(descripcion);
        else
            throw new OtraException("No existe el servicio");
    }
    
    public void agregarCliente(String nombreApe, String email, String telefono, String CUIT, String razonSocial,String grupoClientes) throws OtraException
    {
        if (this.base.getClientes().containsKey(nombreApe))
            throw new OtraException("Cliente ya registrado");
        else
            this.base.getClientes().put(nombreApe, new Cliente(nombreApe,email,telefono,CUIT,razonSocial,grupoClientes));
    }
    
    public void eliminarCliente(String nombreApe) throws OtraException
    {
        if (this.base.getClientes().containsKey(nombreApe))
            this.base.getClientes().remove(nombreApe);
        else
            throw new OtraException("No existe el cliente");
    }
    
    public ArrayList<String[]> informeEstadoTareas()
    {
        ArrayList<String[]> informe=new ArrayList<String[]>();
        Iterator<Tarea> it= this.base.getTareas().iterator();
        while (it.hasNext())
        {
            String[] aux= it.next().getInforme();
            if (aux!=null)
                informe.add(aux);
        }
        return informe;
    }
    
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
                horas=((t.getFechaCierre().getTime() - t.getFechaInicio().getTime())/1000)/3600;
                tot+=t.getCostoTotal();
                res+=t.getServicio().getDescripcion()+"   "+horas+"   "+t.getCostoTotal()+"\n";
            }
        }
        res+="IMPORTE TOTAL: $"+tot;
        this.setChanged();
        this.notifyObservers(res);
    }
    
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
                horas=((aux.getFechaCierre().getTime()-aux.getFechaInicio().getTime())/1000)/3600;
                tot+=horas;
                res+=aux.getCliente()+"   "+aux.getServicio()+"   "+horas+"\n";   
            }
        }
        res+="TOTAL HORAS: "+tot+"hs";
        this.setChanged();
        this.notifyObservers(res);
    }
    
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
                    horas=((aux.getFechaCierre().getTime()-aux.getFechaInicio().getTime())/1000)/3600;
                    if(aux.getFechaInicio().after(inicio)&&aux.getFechaInicio().before(fin))
                        res+=aux.getCliente()+"   "+aux.getServicio().getDescripcion()+"   "+dataux.format(inicio)+"   "+aux.getEstado().toString()+"   "+horas+"\n";
                }
        }
        this.setChanged();
        this.notifyObservers(res);
    }
}
