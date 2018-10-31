package Controlador;

import Modelo.Administrador;
import Modelo.BaseDeDatos;
import Modelo.GeneralException;
import Modelo.Serialize;
import Modelo.Usuario;

import Vista.VentanaGeneral;
import Vista.VentanaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Controlador implements ActionListener, Observer
{
    public static final String ADDUSER = "ADDUSER";
    public static final String ADDGRUPO = "ADDGRUPO";
    public static final String ADDCLIENTE = "ADDCLIENTE";
    public static final String ADDTAREA = "ADDTAREA";
    public static final String DELETUSER = "DELETUSER";
    public static final String DELETCLIENTE = "DELETCLIENTE";
    public static final String INFORMTAREACLIENTE="INFORMTAREACLIENTE";
    public static final String INFORMCOLABOR="INFORMCOLABOR";
    public static final String INFORMUSER="INFORMUSER";
    public static final String INFORMATAREAS="INFORMATAREAS";
    public static final String DELETEGRUPO="DELETEGRUPO";
    public static final String DELETETAREA="DELETETAREA";
    private ArrayList<Observable> observables = new ArrayList<Observable>();
    public static final String LOGIN = "LOGN";
    private BaseDeDatos bdd;
    private VentanaLogin ventanaLogin;
    private Usuario usuario;
    private Administrador admin;
    private VentanaGeneral ventanGeneral;

    public ArrayList<Observable> getObservables()
    {
        return observables;
    }

    public BaseDeDatos getBdd()
    {
        return bdd;
    }

    public VentanaLogin getVentanaLogin()
    {
        return ventanaLogin;
    }

    public Controlador()
    {
        super();
        this.ventanaLogin = new VentanaLogin(this);

        this.ventanaLogin.addActionListener(this);
        //this.agregarObservable   Falta agregar los observables
        this.bdd = Serialize.deserializar();
        if (this.bdd != null)
        {
            System.out.println("Ya existia");
        } else
        {
            this.bdd = new BaseDeDatos();
            System.out.println("nueva base de datos");
        }
    }

    /** Este metodo agrega un observable a la lista de observables del Controlador. <br>
     * <b>pre:</b> La lista de observables esta inicializada.
     * <b>post:</b> Se agrega el observable a la lista de observables y a su vez el obersvable agrega al controlador como su observador.<br>
     * @param o Es el observable a agregar. <br>
     */
    public void agregarObservable(Observable o)
    {
        if (!this.observables.contains(o))
        {
            this.observables.add(o);
            o.addObserver(this);
        }
    }

    /** Actualiza a las ventantas y puede informar al Modelo si debe hacer algun cambio: dependiendo de los eventos captados en la vista, aqui el controlador interactua desde la vista hacia el modelo. Ademas tambien dependiendo el evento se puede hacer algun cambio en las vistas.<br>
     * @param actionEvent Es el evento captado por la vista que es enviado al controlador ya que es quien escucha a la vista mediante la implementacion de ActionListener<br>.
     * <b>pre:</b> La ventana es distinta de null.
     * <b>post:</b>  Se modifico algun aspecto de la ventana, o se creo una nueva ventana con los chats de un solo robot, o se capturo una pregunta o respuesta que el Modelo debera evaluar y efectuar algun cambio.<br>
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if (actionEvent.getActionCommand().equals(Controlador.LOGIN))
        {
            String nombreusuario = this.ventanaLogin.darUsuario();
            String pass = this.ventanaLogin.darPass();
            this.admin = this.bdd.esadmin(nombreusuario, pass);
            if (this.admin != null)
            {
                this.ventanaLogin.setVisible(false);
                this.ventanGeneral = new VentanaGeneral(this);
                this.ventanGeneral.addActionListener(this);
            } else
            {
               // this.usuario = this.bdd.buscarUsuario(nombreusuario, pass);
                if (this.usuario != null)
                {
                    /**Ventana COLABORADOR*/
                } else
                    this.ventanaLogin.mostrarError("Los datos son incorrectos");
            }
        }
        if (actionEvent.getActionCommand().equals(Controlador.ADDGRUPO))
        {
            String titulo = "Creando Grupo";
            String nombre = this.ventanGeneral.IngresarTexto(titulo, "Ingrese su nombre");
            if (nombre.length() > 0)
            {
                String ID = this.ventanGeneral.IngresarTexto(titulo, "Ingrese ID");
                if (ID.length() > 0)
                {
                    int id = Integer.parseInt(ID);
                    try
                    {
                        this.admin.agregarGrupo(nombre, id);
                        this.ventanGeneral.mostrarValidacion("Creacion exitosa", "Creando Grupo");
                    } catch (GeneralException e)
                    {
                        this.ventanGeneral.mostrarError("Ya existe un Grupo con esa ID");
                    }
                } else
                    this.ventanGeneral.mostrarError("Valor nulo");
            } else
                this.ventanGeneral.mostrarError("Valor nulo");
        }
        if (actionEvent.getActionCommand().equals(Controlador.ADDUSER))
        {
            String titulo = "Creando Usuario";
            String nombreApe = this.ventanGeneral.IngresarTexto(titulo, "Ingrese su nombre");
            if (nombreApe.length() > 0)
            {
                String email = this.ventanGeneral.IngresarTexto(titulo, "Ingrese email");
                if (email.length() > 0)
                {
                    String telefono = this.ventanGeneral.IngresarTexto(titulo, "Ingrese telefono");
                    if (email.length() > 0)
                    {
                        String nombreUsuario = this.ventanGeneral.IngresarTexto(titulo, "Ingrese nombre de Usuario");
                        if (nombreUsuario.length() > 0)
                        {
                            String contraseña = this.ventanGeneral.IngresarTexto(titulo, "Ingrese una contraseña");
                            if (contraseña.length() > 0)
                            {
                                try
                                {
                                    this.admin.agregarUsuario(nombreApe, email, telefono, nombreUsuario, contraseña,
                                                              this.bdd);
                                    this.ventanGeneral.mostrarValidacion("Creacion exitosa", "Creando usuario");
                                } catch (GeneralException e)
                                {
                                    this.ventanGeneral.mostrarError("Ya existe un usuario con ese nombre de usuario");
                                }
                            } else
                                this.ventanGeneral.mostrarError("Valor nulo");
                        } else
                            this.ventanGeneral.mostrarError("Valor nulo");
                    } else
                        this.ventanGeneral.mostrarError("Valor nulo");
                } else
                    this.ventanGeneral.mostrarError("Valor nulo");
            } else
                this.ventanGeneral.mostrarError("Valor nulo");
        }
        if (actionEvent.getActionCommand().equals(Controlador.ADDCLIENTE))
        {
            /**String nombreApe, String email, String telefono, String CUIT, String razonSocial,String grupoClientes*/
            String titulo = "Creando Cliente";
            String nombreApe = this.ventanGeneral.IngresarTexto(titulo, "Ingrese su nombre");
            if (nombreApe.length() > 0)
            {
                String email = this.ventanGeneral.IngresarTexto(titulo, "Ingrese email");
                if (email.length() > 0)
                {
                    String telefono = this.ventanGeneral.IngresarTexto(titulo, "Ingrese telefono");
                    if (email.length() > 0)
                    {
                        String cuit = this.ventanGeneral.IngresarTexto(titulo, "Ingrese CUILT");
                        if (cuit.length() > 0)
                        {
                            String razonSocial = this.ventanGeneral.IngresarTexto(titulo, "Ingrese una razonSocial");
                            if (razonSocial.length() > 0)
                            {
                                String grupoClientes =
                                    this.ventanGeneral.IngresarTexto(titulo, "Ingrese una grupo de Clientes");
                                if (grupoClientes.length() > 0)
                                {
                                    try
                                    {
                                        this.admin.agregarCliente(nombreApe, email, telefono, cuit, razonSocial,
                                                                  grupoClientes);
                                        this.ventanGeneral.mostrarValidacion("Creacion exitosa", "Creando Cliente");
                                    } catch (GeneralException e)
                                    {
                                        this.ventanGeneral.mostrarError("Ya existe un Cliente con ese nombre de usuario");
                                    }
                                }

                                else
                                    this.ventanGeneral.mostrarError("Valor nulo");
                            } else
                                this.ventanGeneral.mostrarError("Valor nulo");
                        } else
                            this.ventanGeneral.mostrarError("Valor nulo");
                    } else
                        this.ventanGeneral.mostrarError("Valor nulo");
                } else
                    this.ventanGeneral.mostrarError("Valor nulo");
            } else
                this.ventanGeneral.mostrarError("Valor nulo");
        }
        if (actionEvent.getActionCommand().equals(Controlador.DELETUSER))
        {
            String[] nombres = this.bdd.darListausarios();
            String nom = this.ventanGeneral.eliminarNombre(nombres, "Seleccione un usuario");
            if (nom != null)
            {
                this.admin.eliminarUsuario(nom);
                this.ventanGeneral.mostrarValidacion("La eliminacion fue exitosa", "Borrando Usuario");
            }
        }
        if (actionEvent.getActionCommand().equals(Controlador.DELETCLIENTE))
        {
            String[] nombres = this.bdd.darClientes();
            if (nombres != null)
            {
                String nom = this.ventanGeneral.eliminarNombre(nombres, "Seleccione un cliente");
                if (nom != null)
                {
                    this.admin.eliminarUsuario(nom);
                    this.ventanGeneral.mostrarValidacion("La eliminacion fue exitosa", "Borrando cliente");
                }
            }
            else
            this.ventanGeneral.mostrarError("No hay clientes para borrar");
        }
        if(actionEvent.getActionCommand().equals(INFORMTAREACLIENTE))
        {
            String titulo = "Ingreso de Datos Necesarios";
            String nombre=this.ventanGeneral.IngresarTexto(titulo, "Ingrese nombre del cliente");
            Date datinicio=null;Date datefin=null;
            if(nombre.length()>0)
            {
                DateFormat dataux=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                String inicio = this.ventanGeneral.IngresarTexto(titulo, "Ingrese fecha de inicio(yyyy-mm-dd hh:mm:ss)");
                try
                {
                    datinicio = dataux.parse(inicio);
                } catch (ParseException e){}
                String fin = this.ventanGeneral.IngresarTexto(titulo, "Ingrese fecha de fin(yyyy-mm-dd hh:mm:ss)");
                try
                {
                    datefin = dataux.parse(fin);
                } catch (ParseException e){}
            }
            else
                    this.ventanGeneral.mostrarError("Nombre invalido");
            if(this.admin!=null)
                this.admin.informeTareasPeriodo(nombre, datinicio, datefin);
        }
        if(actionEvent.getActionCommand().equals(INFORMCOLABOR))
        {
            String titulo = "Ingreso de Datos Necesarios";
            String nombre=this.ventanGeneral.IngresarTexto(titulo, "Ingrese nombre del colaborador");
            Date datinicio=null;Date datefin=null;
            if(nombre.length()>0)
            {
                DateFormat dataux=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                String inicio = this.ventanGeneral.IngresarTexto(titulo, "Ingrese fecha de inicio(yyyy-mm-dd hh:mm:ss)");
                try
                {
                    datinicio = dataux.parse(inicio);
                } catch (ParseException e){}
                String fin = this.ventanGeneral.IngresarTexto(titulo, "Ingrese fecha de fin(yyyy-mm-dd hh:mm:ss)");
                try
                {
                    datefin = dataux.parse(fin);
                } catch (ParseException e){}
            }
            if(this.admin!=null)
                this.admin.informeTareasPeriodo(nombre, datinicio, datefin);
        }
        if(actionEvent.getActionCommand().equals(INFORMUSER))
        {
            String titulo = "Ingreso de Datos Necesarios";
            String nombre=this.ventanGeneral.IngresarTexto(titulo, "Ingrese nombre del colaborador");
            Date datinicio=null;Date datefin=null;
            if(nombre.length()>0)
            {
                String estado=this.ventanGeneral.IngresarTexto(titulo, "Ingrese el estado que desea ver(Ingrese <Todos> para considerarlos todos");
                if(estado.equalsIgnoreCase("Todos")||estado.equalsIgnoreCase("Abierta")||estado.equalsIgnoreCase("Cerrada")||estado.equalsIgnoreCase("Pausada"))
                {
                    DateFormat dataux=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                    String inicio = this.ventanGeneral.IngresarTexto(titulo, "Ingrese fecha de inicio(yyyy-mm-dd hh:mm:ss)");
                    try
                    {
                        datinicio = dataux.parse(inicio);
                    } catch (ParseException e){}
                    String fin = this.ventanGeneral.IngresarTexto(titulo, "Ingrese fecha de fin(yyyy-mm-dd hh:mm:ss)");
                    try
                    {
                        datefin = dataux.parse(fin);
                    } catch (ParseException e){}   
                }
            }
            if(this.usuario!=null)
                this.admin.informeTareasPeriodo(nombre, datinicio, datefin);
        }
        if(actionEvent.getActionCommand().equals(INFORMATAREAS))
        {
            if(this.admin!=null)
            {
                this.admin.informeEstadoTareas("todos");//Hay que revisar esto
            }
        }
        if(actionEvent.getActionCommand().equals(DELETEGRUPO))
        {
            int i;
            if(this.admin!=null)
            {
                String titulo = "Borrar un Grupo de Clientes";
                String aux=this.ventanGeneral.IngresarTexto(titulo,"Ingrese el numero de grupo que desea eliminar");
                i=Integer.parseInt(aux);
                if(i<=this.bdd.getGrupos().size())
                    this.bdd.deleteGRupo(i);
                else
                    this.ventanGeneral.mostrarError("Numero de grupo inexistente");
            }
        }
        if(actionEvent.getActionCommand().equals(DELETETAREA))
        {
            int i;
            if(this.admin!=null)
            {
                String aux=this.ventanGeneral.IngresarTexto("Borrar una Tarea","Ingrese el ID de tarea que desea eliminar");
                i=Integer.parseInt(aux);
                
            }
        }
    }

    /** Este metodo se ejecuta cuando los objetos observados por el Controlador ejecutan el notifyObservers();.<br>
     * @param observable El observable que ejecuto el metodo notifyObservers();.<br>
     * @param object Objeto que pasa como paramatro al notificar el observable a su observador. En este caso se utiliza como tipo String.<br>
     * <b>pre:</b> La lista de observables ya esta incializada.<br>
     * <b>post:</b> Se modifica la ventana cada vez que se modifica la cantidad de participantes, o se pueden actualizar los chats a medida que los participantes interactuan, donde el controlador manda a actualizar las ventanas.<br>
     */
    @Override
    public void update(Observable observable, Object object)
    {
        if(this.observables.contains(observable))
            this.ventanGeneral.getJTextArea().append((String) object);
        else
            throw new IllegalArgumentException();
    }

    public void terminar()
    {
        Serialize.serializar(this.bdd);
        System.exit(0);
    }
}
