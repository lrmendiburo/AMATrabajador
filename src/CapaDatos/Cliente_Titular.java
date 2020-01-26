package CapaDatos;

import static CapaDatos.Cliente_Contratado.leer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Cliente_Titular {

    int id_ClienteTitular;
    String nombre;
    String apellido;
    String direccion;
    String municipio;
    int telefono1;
    int telefono2;
    float servicio;
    String nota;
    int id_Oficina;

    public Cliente_Titular(int id_ClienteTitular, String nombre, String apellido, String direccion, String municipio, int telefono1, int telefono2, float servicio, String nota, int id_Oficina) {
        this.id_ClienteTitular = id_ClienteTitular;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.municipio = municipio;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.servicio = servicio;
        this.nota = nota;
        this.id_Oficina = id_Oficina;
    }

    static void insertar(Cliente_Titular cliente_Contratado) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Cliente_Titular (ID_ClienteTitular, Nombre, Apellido,"
                    + "Direccion, Municipio, Telefono1, Telefono2, Servicio, Nota, OficinaID_Oficina)"
                    + "VALUES (" + cliente_Contratado.id_ClienteTitular + ", "
                    + "'" + cliente_Contratado.nombre + "', "
                    + "'" + cliente_Contratado.apellido + "', "
                    + "'" + cliente_Contratado.direccion + "', "
                    + "'" + cliente_Contratado.municipio + "', "
                    + "" + cliente_Contratado.telefono1 + ", "
                    + "" + cliente_Contratado.telefono2 + ", "
                    + "" + cliente_Contratado.servicio + ", "
                    + "'" + cliente_Contratado.nota + "', "
                    + "" + cliente_Contratado.id_Oficina + ");";

            stmt.executeUpdate(sql);

            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<Cliente_Titular> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<Cliente_Titular> lista = new ArrayList<Cliente_Titular>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente_Titular;");
            while (rs.next()) {
                int id_ClienteTitular = rs.getInt("id_ClienteTitular");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String direccion = rs.getString("direccion");
                String municipio = rs.getString("municipio");
                int telefono1 = rs.getInt("telefono1");
                int telefono2 = rs.getInt("telefono2");
                float servicio = rs.getFloat("servicio");
                String nota = rs.getString("nota");
                int id_Oficina = rs.getInt("id_Oficina");
                Cliente_Titular cliente_Titular = new Cliente_Titular(id_ClienteTitular, nombre, apellido, direccion, municipio, telefono1, telefono2, servicio, nota, id_Oficina);
                lista.add(cliente_Titular);

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

    static void actualizar(Cliente_Titular cliente_Contratado, int id_ClienteTitularOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            int id_ClienteTitular = cliente_Contratado.id_ClienteTitular;
            String nombre = cliente_Contratado.nombre;
            String apellido = cliente_Contratado.apellido;
            String direccion = cliente_Contratado.direccion;
            String municipio = cliente_Contratado.municipio;
            int telefono1 = cliente_Contratado.telefono1;
            int telefono2 = cliente_Contratado.telefono2;
            float servicio = cliente_Contratado.servicio;
            String nota = cliente_Contratado.nota;
            int id_Oficina = cliente_Contratado.id_Oficina;

            String sql = "UPDATE Cliente_Titular set ID_ClienteTitular=" + id_ClienteTitular + " , "
                    + "Nombre='" + nombre + "', "
                    + "Apellido='" + apellido + "', "
                    + "Direccion='" + direccion + "', "
                    + "Municipio='" + municipio + "', "
                    + "Telefono1=" + telefono1 + ", "
                    + "Telefono2=" + telefono2 + ", "
                    + "Servicio=" + servicio + ", "
                    + "Nota='" + nota + "', "
                    + "OficinaID_Oficina='" + id_Oficina + "', "
                    + "where ID_ClienteTitular=" + id_ClienteTitularOld + " ;";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static void eliminar(int id_ClienteTitular) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE from Cliente_Titular where ID_ClienteTitular = " + id_ClienteTitular + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<Cliente_Titular> buscarXNombre(String nombre) {
        ArrayList<Cliente_Titular> lista = leer();
        ArrayList<Cliente_Titular> listaF = new ArrayList<Cliente_Titular>();
        for (Cliente_Titular ct : lista) {
            if (ct.nombre.equals(nombre)) {
                listaF.add(ct);
            }
        }
        return listaF;
    }

    public int contarClienteTitular() {
        int cantidad = 0;
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT * FROM Cliente_Titular;");
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
