package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Colaborador extends Usuario
{
    private HashMap<Integer,Tarea> tareas=new HashMap<Integer,Tarea>();
    
    public Colaborador(String string, String string1, String string2, String string3, String string5,BaseDeDatos base)
    {
        super(string, string1, string2, string3, "Colaborador", string5,base);
    }

    public Colaborador()
    {
        super();
    }
    
    public void agregarTarea(int ID,Cliente cliente,Servicio servicio) throws OtraException
    {
        if (this.ningunaAbierta())
        {
            Tarea t=new Tarea(this,cliente,servicio,ID);
            this.base.getTareas().add(t);
            this.tareas.put(ID, t);
        }
        else
            throw new OtraException("Hay tareas abiertas");
    }
    
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

    public void setTareas(HashMap<Integer, Tarea> tareas)
    {
        this.tareas = tareas;
    }

    public HashMap<Integer, Tarea> getTareas()
    {
        return tareas;
    }

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
