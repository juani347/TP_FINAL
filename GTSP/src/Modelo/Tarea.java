package Modelo;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.plaf.nimbus.State;

public class Tarea
{
    //private ArrayList<Colaborador> colaborador= new ArrayList<Colaborador>();
    private int ID;
    private Colaborador colaborador;
    private Cliente cliente;
    private Servicio servicio;
    private Date fechaInicio;
    private Date fechaCierre=null;
    private IState estado;
    private double costoTotal=0;
    
    public Tarea(){}

    public Tarea(Colaborador colaborador, Cliente cliente,Servicio servicio, int ID)
    {
        //this.colaborador.add(colaborador);
        this.colaborador= colaborador;
        this.cliente = cliente;
        this.fechaInicio = new Date();
        this.estado=new AbiertaState(this);
        this.ID=ID;
    }


    public void setColaborador(Colaborador colaborador)
    {
        this.colaborador = colaborador;
    }

    public Colaborador getColaborador()
    {
        return colaborador;
    }

    /* public void setColaborador(ArrayList<Colaborador> colaborador)
    {
        this.colaborador = colaborador;
    }

    public ArrayList<Colaborador> getColaborador()
    {
        return colaborador;
    } */


    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setServicio(Servicio servicio)
    {
        this.servicio = servicio;
    }

    public Servicio getServicio()
    {
        return servicio;
    }

    public void setFechaInicio(Date fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaCierre(Date fechaCierre)
    {
        this.fechaCierre = fechaCierre;
    }

    public Date getFechaCierre()
    {
        return fechaCierre;
    }

    public void setEstado(IState estado)
    {
        this.estado = estado;
    }

    public IState getEstado()
    {
        return estado;
    }

    public void setCostoTotal(double costoTotal)
    {
        this.costoTotal = costoTotal;
    }

    public double getCostoTotal()
    {
        return costoTotal;
    }
    
    public Integer getHoras()
    {
        Integer horas=null;
        return horas;
    }
    
    public String[] getInforme()
    {
        return this.estado.getInforme();
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getID()
    {
        return ID;
    }
}
