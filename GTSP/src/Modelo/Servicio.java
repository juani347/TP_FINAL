package Modelo;

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
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setCosto(double costo)
    {
        this.costo = costo;
    }

    public double getCosto()
    {
        return costo;
    }

}
