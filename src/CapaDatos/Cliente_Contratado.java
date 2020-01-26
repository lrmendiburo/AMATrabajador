package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Cliente_Contratado {

    int id_ClienteContratado;
    String nombre;
    String apellido;
    String direccion;
    String municipio;
    int telefono1;
    int telefono2;
    float servicio;
    String nota;
    int id_Oficina;
    int id_TrabajadorTitular;

    public Cliente_Contratado(int id_ClienteContratado, String nombre, String apellido, String direccion, String municipio, int telefono1, int telefono2, float servicio, String nota, int id_Oficina, int id_TrabajadorTitular) {
        this.id_ClienteContratado = id_ClienteContratado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.municipio = municipio;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.servicio = servicio;
        this.nota = nota;
        this.id_Oficina = id_Oficina;
        this.id_TrabajadorTitular = id_TrabajadorTitular;
    }

    static void insertar(Cliente_Contratado cliente_Contratado) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Cliente_Contratado (ID_ClienteContratado, Nombre, Apellido,"
                    + "Direccion, Municipio, Telefono1, Telefono2, Servicio, Nota, OficinaID_Oficina, "
                    + "Cliente_TitularID_ClienteTitular) "
                    + "VALUES (" + cliente_Contratado.id_ClienteContratado + ", "
                    + "'" + cliente_Contratado.nombre + "', "
                    + "'" + cliente_Contratado.apellido + "', "
                    + "'" + cliente_Contratado.direccion + "', "
                    + "'" + cliente_Contratado.municipio + "', "
                    + "" + cliente_Contratado.telefono1 + ", "
                    + "" + cliente_Contratado.telefono2 + ", "
                    + "" + cliente_Contratado.servicio + ", "
                    + "'" + cliente_Contratado.nota + "', "
                    + "" + cliente_Contratado.id_Oficina + ", "
                    + "" + cliente_Contratado.id_TrabajadorTitular + ");";

            stmt.executeUpdate(sql);

            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<Cliente_Contratado> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<Cliente_Contratado> lista = new ArrayList<Cliente_Contratado>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente_Contratado;");
            while (rs.next()) {
                int id_ClienteContratado = rs.getInt("id_ClienteContratado");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String direccion = rs.getString("direccion");
                String municipio = rs.getString("municipio");
                int telefono1 = rs.getInt("telefono1");
                int telefono2 = rs.getInt("telefono2");
                float servicio = rs.getFloat("servicio");
                String nota = rs.getString("nota");
                int id_Oficina = rs.getInt("id_Oficina");
                int id_TrabajadorTitular = rs.getInt("id_TrabajadorTitular");
                Cliente_Contratado cliente_Contratado = new Cliente_Contratado(id_ClienteContratado, nombre, apellido, direccion, municipio, telefono1, telefono2, servicio, nota, id_Oficina, id_TrabajadorTitular);
                lista.add(cliente_Contratado);

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

    static void actualizar(Cliente_Contratado cliente_Contratado, int id_ClienteContratadoOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            int id_ClienteContratado = cliente_Contratado.id_ClienteContratado;
            String nombre = cliente_Contratado.nombre;
            String apellido = cliente_Contratado.apellido;
            String direccion = cliente_Contratado.direccion;
            String municipio = cliente_Contratado.municipio;
            int telefono1 = cliente_Contratado.telefono1;
            int telefono2 = cliente_Contratado.telefono2;
            float servicio = cliente_Contratado.servicio;
            String nota = cliente_Contratado.nota;
            int id_Oficina = cliente_Contratado.id_Oficina;
            int id_TrabajadorTitular = cliente_Contratado.id_TrabajadorTitular;

            String sql = "UPDATE Cliente_Contratado set ID_ClienteContratado=" + id_ClienteContratado + " , "
                    + "Nombre='" + nombre + "', "
                    + "Apellido='" + apellido + "', "
                    + "Direccion='" + direccion + "', "
                    + "Municipio='" + municipio + "', "
                    + "Telefono1=" + telefono1 + ", "
                    + "Telefono2=" + telefono2 + ", "
                    + "Servicio=" + servicio + ", "
                    + "Nota='" + nota + "', "
                    + "OficinaID_Oficina='" + id_Oficina + "', "
                    + "Cliente_TitularID_ClienteTitular='" + id_TrabajadorTitular + "' "
                    + "where ID_ClienteContratado=" + id_ClienteContratadoOld + " ;";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static void eliminar(int id_ClienteContratado) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE from Cliente_Contratado where ID_ClienteContratado = " + id_ClienteContratado + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<Cliente_Contratado> buscarXNombre(String nombre) {
        ArrayList<Cliente_Contratado> lista = leer();
        ArrayList<Cliente_Contratado> listaF = new ArrayList<Cliente_Contratado>();
        for (Cliente_Contratado cc : lista) {
            if (cc.nombre.equals(nombre)) {
                listaF.add(cc);
            }
        }
        return listaF;
    }

}
