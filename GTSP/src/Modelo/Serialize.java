package Modelo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 * Clase utilizada para serializar la Base de datos del programa.
 */
public class Serialize
{
    public static final String SERIALIZED_NAME = "basededatos.xml";
    
    public Serialize()
    {
        super();
    }
    
    /**
     *Método que serializa la base de datos del programa en un archvio XML
     * @param bdd Base de datos del programa a serializar, debe ser distinto de null.
     * <b>pre:</b>
     * bdd!=null<br>
     */
    public static void serializar(BaseDeDatos bdd)
    {
        XMLEncoder encoder=null;
        try
        {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(Serialize.SERIALIZED_NAME)));
           
            encoder.writeObject(bdd);
                
                    encoder.close();
            System.out.print("se almaceno la bdd\n");
            
        } catch (FileNotFoundException e)
        {
            System.out.print("no se almaceno la bdd");
        }
    }
    /**
     * Metodo que deserializa la base de datos del programa de un archvio XML.<br>
     * @return Devuelve la Base de datos obtenida del archivo.
     */
    public static BaseDeDatos deserializar()
       {
           BaseDeDatos resp=null;
           XMLDecoder decoder=null;
           try
           {
               decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(Serialize.SERIALIZED_NAME)));
               
               resp=(BaseDeDatos)decoder.readObject();
               decoder.close();
       } catch (FileNotFoundException e)
           {
           }
           return resp;
       }
}
