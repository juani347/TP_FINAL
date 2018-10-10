package Modelo;

import java.util.ArrayList;

public interface IState
{
    void abrir();
    void cerrar();
    void pausar();
    String[] getInforme();
}
