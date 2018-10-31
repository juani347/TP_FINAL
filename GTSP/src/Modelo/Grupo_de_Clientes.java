package Modelo;

/**Clase que agrupo a los clientes
 * <b>inv:</b><br>
 * nombre!=null
 * !nombre.equals("")
 * ID>=0
 */
public class Grupo_de_Clientes
{
    private String nombre;
    private int ID;
    
    public Grupo_de_Clientes(){}

    /**
     * @param nombre
     * @param ID
     * <b>pre:</b> 
     * nombre!=null && !equals("")<br>
     * ID!=null.<br>
     * <b>post:</b> Se crea un grupo de clientes.<br>
     */
    public Grupo_de_Clientes(String nombre, int ID)
    {
        this.nombre = nombre;
        this.ID = ID;
        this.verificarInvariante();
    }
    
    /**
     * @param nombre
     * <b>pre:</b> nombre!=null && !nombre.equals("")
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
        this.verificarInvariante();
    }

    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * @param ID
     * <b>pre:</b> ID>0
     */
    public void setID(int ID)
    {
        this.ID = ID;
        this.verificarInvariante();
    }

    public int getID()
    {
        return ID;
    }
    
    private void verificarInvariante()
    {
        assert nombre!=null : "El Nombre es nulo";
        assert !nombre.equals("") : "El nombre esta vacio";
        assert ID>=0 : "El ID es menor a cero";
    }
}
