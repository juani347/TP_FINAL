package Modelo;


/**Clase que agrupo a los clientes
 */
public class Grupo_de_Clientes
{
    private String nombre;
    private int ID;
    
    public Grupo_de_Clientes()
    {
        super();
    }

    public Grupo_de_Clientes(String nombre, int ID)
    {
        this.nombre = nombre;
        this.ID = ID;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
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
