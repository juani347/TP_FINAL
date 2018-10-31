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

    /**
     * @param descripcion
     * @param tipo
     * @param costo
     * <b>pre:</b> 
     * descripcion!=null && !equals("")<br>
     * tipo!=null && !equals("")<br>
     * costo>=0<br>
     * <b>post:</b> Se crea un servicio.<br>
     */
    public Servicio(String descripcion, String tipo, double costo)
    {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.costo = costo;
        this.verificaInvariante();
    }
    
    /**
     * @param descripcion
     * <b>pre:</b> descripcion!=null && !descripcion.equals("")
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
        this.verificaInvariante();
    }

    public String getDescripcion()
    {
        return descripcion;
    }
    
    /**
     * @param tipo
     * <b>pre:</b> tipo!=null && !tipo.equals("")
     */
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
        this.verificaInvariante();
    }

    public String getTipo()
    {
        return tipo;
    }
    
    /**
     * @param costo
     * <b>pre:</b> costo>=0
     */
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
