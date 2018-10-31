package Modelo;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.plaf.nimbus.State;

/** Clase tarea realizada por el Colaborador hacia el cliente
 * <b>inv: </b><br>
 * ID>=1 <br>
 * colaborador!=null <br>
 * cliente!=null <br>
 * servicio!=null <br>
 * fechaInicio!=null <br>
 * estado!=null <br>
 * costoTotal>=0 <br>
 * num>1 <br>
 */
public class Tarea
{
    private int ID;
    private Colaborador colaborador;
    private Cliente cliente;
    private Servicio servicio;
    private Date fechaInicio;
    private Date fechaCierre=null;
    private IState estado;
    private double costoTotal=0;
    private static int num=0;
    
    public Tarea(){}

    /**
     * @param colaborador
     * @param cliente
     * @param servicio
     * <b>pre:</b> 
     * colaborador!=null.<br>
     * cliente!=null.<br>
     * servicio!=null.<br>
     * <b>post:</b> Se crea una tarea.<br>
     */
    public Tarea(Colaborador colaborador, Cliente cliente,Servicio servicio)
    {
        this.colaborador= colaborador;
        this.cliente = cliente;
        this.fechaInicio = new Date();
        this.estado=new AbiertaState(this);
        num+=1;
        this.ID=num;
        this.verificaInvariante();
    }


    public void setColaborador(Colaborador colaborador)
    {
        this.colaborador = colaborador;
        this.verificaInvariante();
    }

    public Colaborador getColaborador()
    {
        return colaborador;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
        this.verificaInvariante();
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setServicio(Servicio servicio)
    {
        this.servicio = servicio;
        this.verificaInvariante();
    }

    public Servicio getServicio()
    {
        return servicio;
    }

    public void setFechaInicio(Date fechaInicio)
    {
        this.fechaInicio = fechaInicio;
        this.verificaInvariante();
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
        this.verificaInvariante();
    }

    public IState getEstado()
    {
        return estado;
    }

    public void setCostoTotal(double costoTotal)
    {
        this.costoTotal = costoTotal;
        this.verificaInvariante();
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

    /** Metodo que informa estado de la tarea
     * @return String[] vector string con cada informacion solicitada por campo
     */
    public String[] getInforme()
    {
        return this.estado.getInforme();
    }

    public void setID(int ID)
    {
        this.ID = ID;
        this.verificaInvariante();
    }

    public int getID()
    {
        return ID;
    }
    
    private void verificaInvariante()
    {
        assert ID>=1: "ID negativa o de valor cero";
        assert colaborador!=null: "colaborador nulo";
        assert cliente!=null: "cliente nulo";
        assert servicio!=null: "servicio nulo";
        assert fechaInicio!=null: "fechaInicio nula";
        assert costoTotal>=0: "costoTotal negativo";
        assert num>1: "num negativo o de valor cero";
    }
}
