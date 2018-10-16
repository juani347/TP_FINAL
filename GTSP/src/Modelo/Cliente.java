package Modelo;

/** Clase del cliente a quien los colaboradores realizan la tarea
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
    
    public Cliente(String nombreApe, String email, String telefono, String CUIT, String razonSocial,String grupoClientes)
    {
        this.nombreApe = nombreApe;
        this.email = email;
        this.telefono = telefono;
        this.CUIT = CUIT;
        this.razonSocial = razonSocial;
        this.grupoClientes = grupoClientes;
    }


    public void setNombreApe(String nombreApe)
    {
        this.nombreApe = nombreApe;
    }

    public String getNombreApe()
    {
        return nombreApe;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setCUIT(String CUIT)
    {
        this.CUIT = CUIT;
    }

    public String getCUIT()
    {
        return CUIT;
    }

    public void setRazonSocial(String razonSocial)
    {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial()
    {
        return razonSocial;
    }

    public void setGrupoClientes(String grupoClientes)
    {
        this.grupoClientes = grupoClientes;
    }

    public String getGrupoClientes()
    {
        return grupoClientes;
    }
}
