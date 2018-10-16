package Modelo;

/**
* <b>inv:</b><br>
* descripcion!=null<br>
* !descripcion.equals("")<br>
* tipo!=null<br>
* !tipo.equals("")<br>
* costo>=0
*/
public class Servicio
{
    public static String FIJO="FIJO";
    public static String XHORA="POR HORA";
    private String descripcion;
    private String tipo;
    private double costo;
    
    public Servicio()
    {
        super();
    }

    public Servicio(String descripcion, String tipo, double costo)
    {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.costo = costo;
        this.verificaInvariante();
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
        this.verificaInvariante();
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
        this.verificaInvariante();
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setCosto(double costo)
    {
        this.costo = costo;
        this.verificaInvariante();
    }

    public double getCosto()
    {
        return costo;
    }
    
    private void verificaInvariante()
    {
        assert this.descripcion!=null || !this.descripcion.equals("") : "La descrpción es nula";
        assert this.tipo!=null || !this.tipo.equals("") : "El tipo es nulo";
        assert this.costo>0 : "El precio es negativo";
    }
}
