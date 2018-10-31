package Modelo;

/**Clase de excepcion que se manejan
 */
public class GeneralException extends Exception
{
    public GeneralException(String string)
    {
        super(string);
    }

    public GeneralException()
    {
        super();
    }
}
