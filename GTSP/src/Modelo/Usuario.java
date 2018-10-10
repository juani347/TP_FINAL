package Modelo;

import java.util.Observable;

public class Usuario extends Observable
{
    private String nombreApe;
    private String email;
    private String telefono;
    private String perfil;
    private String nombreUsuario;
    private String contraseña;
    BaseDeDatos base=null;
    
    public Usuario()
    {
        super();
    }

    public Usuario(String nombreApe, String email, String telefono, String perfil, String nombreUsuario, String contraseña, BaseDeDatos base)
    {
        this.nombreApe = nombreApe;
        this.email = email;
        this.telefono = telefono;
        this.perfil = perfil;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.base=base;
    }

    public void setNombreApe(String nomApe)
    {
        this.nombreApe = nomApe;
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

    public void setPerfil(String perfil)
    {
        this.perfil = perfil;
    }

    public String getPerfil()
    {
        return perfil;
    }

    public void setNombreUsuario(String nombreUsuario)
    {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario()
    {
        return nombreUsuario;
    }

    public void setContraseña(String contraseña)
    {
        this.contraseña = contraseña;
    }

    public String getContraseña()
    {
        return contraseña;
    }

    public void setBase(BaseDeDatos base)
    {
        this.base = base;
    }

    public BaseDeDatos getBase()
    {
        return base;
    }
}
