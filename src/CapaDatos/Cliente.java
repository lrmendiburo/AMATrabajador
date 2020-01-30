package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Cliente {

    static int id_Cliente;
    static String nombre;
    static String apellido;
    static String direccion;
    static String municipio;
    static int telefono1;
    static int telefono2;
    static float servicio;
    static String nota;
    static boolean esTitular;
    static boolean tieneTitular;
    static int id_ClienteTitular;
    static int id_Oficina;

    public Cliente(int id_Cliente, String nombre, String apellido, String direccion, String municipio, int telefono1, int telefono2, float servicio, String nota, boolean esTitular, boolean tieneTitular, int id_ClienteTitular, int id_Oficina) {
        this.id_Cliente = id_Cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.municipio = municipio;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.servicio = servicio;
        this.nota = nota;
        this.esTitular = esTitular;
        this.tieneTitular = tieneTitular;
        this.id_ClienteTitular = id_ClienteTitular;
        this.id_Oficina = id_Oficina;
    }

    public static int getId_Cliente() {
        return id_Cliente;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static String getDireccion() {
        return direccion;
    }

    public static String getMunicipio() {
        return municipio;
    }

    public static int getTelefono1() {
        return telefono1;
    }

    public static int getTelefono2() {
        return telefono2;
    }

    public static float getServicio() {
        return servicio;
    }

    public static String getNota() {
        return nota;
    }

    public static boolean isEsTitular() {
        return esTitular;
    }

    public static boolean isTieneTitular() {
        return tieneTitular;
    }

    public static int getId_ClienteTitular() {
        return id_ClienteTitular;
    }

    public static int getId_Oficina() {
        return id_Oficina;
    }

    public static void setId_Cliente(int id_Cliente) {
        Cliente.id_Cliente = id_Cliente;
    }

    public static void setNombre(String nombre) {
        Cliente.nombre = nombre;
    }

    public static void setApellido(String apellido) {
        Cliente.apellido = apellido;
    }

    public static void setDireccion(String direccion) {
        Cliente.direccion = direccion;
    }

    public static void setMunicipio(String municipio) {
        Cliente.municipio = municipio;
    }

    public static void setTelefono1(int telefono1) {
        Cliente.telefono1 = telefono1;
    }

    public static void setTelefono2(int telefono2) {
        Cliente.telefono2 = telefono2;
    }

    public static void setServicio(float servicio) {
        Cliente.servicio = servicio;
    }

    public static void setNota(String nota) {
        Cliente.nota = nota;
    }

    public static void setEsTitular(boolean esTitular) {
        Cliente.esTitular = esTitular;
    }

    public static void setTieneTitular(boolean tieneTitular) {
        Cliente.tieneTitular = tieneTitular;
    }

    public static void setId_ClienteTitular(int id_ClienteTitular) {
        Cliente.id_ClienteTitular = id_ClienteTitular;
    }

    public static void setId_Oficina(int id_Oficina) {
        Cliente.id_Oficina = id_Oficina;
    }

    public static void insertar(Cliente cliente_Contratado) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Cliente (ID_Cliente, Nombre, Apellido,"
                    + "Direccion, Municipio, Telefono1, Telefono2, Servicio, Nota,"
                    + "Es_Titular, Tiene_Titular, OficinaID_Oficina)"
                    + "VALUES (" + cliente_Contratado.id_Cliente + ", "
                    + "'" + cliente_Contratado.nombre + "', "
                    + "'" + cliente_Contratado.apellido + "', "
                    + "'" + cliente_Contratado.direccion + "', "
                    + "'" + cliente_Contratado.municipio + "', "
                    + "" + cliente_Contratado.telefono1 + ", "
                    + "" + cliente_Contratado.telefono2 + ", "
                    + "" + cliente_Contratado.servicio + ", "
                    + "'" + cliente_Contratado.nota + "', "
                    + "" + cliente_Contratado.esTitular + ", "
                    + "" + cliente_Contratado.tieneTitular + ", "
                    + "" + cliente_Contratado.id_ClienteTitular + ", "
                    + "" + cliente_Contratado.id_Oficina + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Cliente> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente;");
            while (rs.next()) {
                int id_Cliente = rs.getInt("id_ClienteTitular");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String direccion = rs.getString("direccion");
                String municipio = rs.getString("municipio");
                int telefono1 = rs.getInt("telefono1");
                int telefono2 = rs.getInt("telefono2");
                float servicio = rs.getFloat("servicio");
                String nota = rs.getString("nota");
                boolean esTitular = rs.getBoolean("esTitular");
                boolean tieneTitular = rs.getBoolean("tieneTitular");
                int id_ClienteTitular = rs.getInt("id_ClienteTitular");
                int id_Oficina = rs.getInt("id_Oficina");
                Cliente cliente = new Cliente(id_Cliente, nombre, apellido, direccion, municipio, telefono1, telefono2, servicio, nota, esTitular, tieneTitular, id_ClienteTitular, id_Oficina);
                lista.add(cliente);
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return lista;

    }

    public static void actualizar(Cliente cliente, int id_ClienteOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            int id_Cliente = cliente.id_Cliente;
            String nombre = cliente.nombre;
            String apellido = cliente.apellido;
            String direccion = cliente.direccion;
            String municipio = cliente.municipio;
            int telefono1 = cliente.telefono1;
            int telefono2 = cliente.telefono2;
            float servicio = cliente.servicio;
            String nota = cliente.nota;
            boolean esTitular = cliente.esTitular;
            boolean tieneTitular = cliente.tieneTitular;
            int idClienteTitular = cliente.id_ClienteTitular;
            int id_Oficina = cliente.id_Oficina;

            String sql = "UPDATE Cliente set ID_Cliente=" + id_Cliente + " , "
                    + "Nombre='" + nombre + "', "
                    + "Apellido='" + apellido + "', "
                    + "Direccion='" + direccion + "', "
                    + "Municipio='" + municipio + "', "
                    + "Telefono1=" + telefono1 + ", "
                    + "Telefono2=" + telefono2 + ", "
                    + "Servicio=" + servicio + ", "
                    + "Nota='" + nota + "', "
                    + "Es_Titular=" + esTitular + ", "
                    + "Tiene_Titular=" + tieneTitular + ", "
                    + "ClienteID_ClienteTitular=" + idClienteTitular + ", "
                    + "OficinaID_Oficina='" + id_Oficina + "', "
                    + "where ID_Cliente=" + id_ClienteOld + " ;";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void eliminar(int id_Cliente) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE from Cliente where ID_Cliente = " + id_Cliente + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Cliente> buscarXNombre(String nombre) {
        ArrayList<Cliente> lista = leer();
        ArrayList<Cliente> listaF = new ArrayList<Cliente>();
        for (Cliente ct : lista) {
            if (ct.nombre.equals(nombre)) {
                listaF.add(ct);
            }
        }
        return listaF;
    }

    public static int contarCliente() {
        int cantidad = 0;
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT (*) FROM Cliente;");
            cantidad = rs.getInt("cantidad");
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return cantidad;
    }

}
