package Modelo;

/** Clase del cliente a quien los colaboradores realizan la tarea
 * <b>inv:</b><br>
 * nombreApe!=null
 * !nombreApe.equals("")
 * email!=null
 * !email.equals("")
 * telefono!=null
 * !telefono.equals("")
 * this.telefono.length()==12
 * CUIT!=null
 * !CUIT.equals("")
 * razonSocial!=null
 * !razonSocial.equals("")
 * grupoClientes!=null
 * !grupoClientes.equals("")
 */
public class Cliente
{
    private String nombreApe;
    private String email;
    private String telefono;
    private String CUIT;
    private String razonSocial;
    private String grupoClientes;

    public Cliente(){}

    /**
     * @param nombreApe
     * @param email
     * @param telefono
     * @param CUIT
     * @param razonSocial
     * @param grupoClientes
     * <b>pre:</b> Todos los parametros deben ser distintos de null y distintos de vacio.<br>
     * <b>post:</b> Se crea un cliente.<br>
     */
    public Cliente(String nombreApe, String email, String telefono, String CUIT, String razonSocial,String grupoClientes)
    {
        this.nombreApe = nombreApe;
        this.email = email;
        this.telefono = telefono;
        this.CUIT = CUIT;
        this.razonSocial = razonSocial;
        this.grupoClientes = grupoClientes;
        this.verificarInvariante();
    }
    
    /**
     * @param nombreApe
     * <b>pre:</b> nombreApe!=null && !nombreApe.equals("")
     */
    public void setNombreApe(String nombreApe)
    {
        this.nombreApe = nombreApe;
        this.verificarInvariante();
    }

    public String getNombreApe()
    {
        return nombreApe;
    }
    
    /**
     * @param email
     * <b>pre:</b> email!=null && !email.equals("")
     */
    public void setEmail(String email)
    {
        this.email = email;
        this.verificarInvariante();
    }

    public String getEmail()
    {
        return email;
    }

    /**
     * @param telefono
     * <b>pre:</b> telefono!=null && !telefono.equals("")
     */
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
        this.verificarInvariante();
    }

    public String getTelefono()
    {
        return telefono;
    }
    
    /**
     * @param CUIT
     * <b>pre:</b> CUIT!=null && !CUIT.equals("")
     */
    public void setCUIT(String CUIT)
    {
        this.CUIT = CUIT;
        this.verificarInvariante();
    }

    public String getCUIT()
    {
        return CUIT;
    }
    
    /**
     * @param razonSocial
     * <b>pre:</b> razonSocial!=null && !razonSocial.equals("")
     */
    public void setRazonSocial(String razonSocial)
    {
        this.razonSocial = razonSocial;
        this.verificarInvariante();
    }

    public String getRazonSocial()
    {
        return razonSocial;
    }
    
    /**
     * @param grupoClientes
     * <b>pre:</b> grupoClientes!=null && !grupoClientes.equals("")
     */
    public void setGrupoClientes(String grupoClientes)
    {
        this.grupoClientes = grupoClientes;
        this.verificarInvariante();
    }

    public String getGrupoClientes()
    {
        return grupoClientes;
    }
    
    private void verificarInvariante()
    {
        assert nombreApe!=null : "El nombre y apellido es nulo";
        assert !nombreApe.equals("") : "El nombre y apellido del esta vacio";
        assert email!=null : "El email es nulo";
        assert !email.equals("") : "El email esta vacio";
        assert telefono!=null : "El telefono es nulo";
        assert !telefono.equals("") : "El telefono esta vacio";
        assert this.telefono.length()==12 : "La longitud del numero de telefono no es 12";
        assert CUIT!=null : "El CUIT es nulo";
        assert !CUIT.equals("") : "El CUIT esta vacio";
        assert razonSocial!=null : "La razon social es nula";
        assert !razonSocial.equals("") : "La razon social esta vacia";
        assert grupoClientes!=null : "El grupo de clientes es nulo";
        assert !grupoClientes.equals("") : "El grupo de clientes esta vacio";
    }
}
