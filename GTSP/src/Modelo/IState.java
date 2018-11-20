package Modelo;

/**Interface State
 */
public interface IState
{
    void abrir();
    void cerrar();
    void pausar();
    long getHoras();
    String[] getInforme();
}
