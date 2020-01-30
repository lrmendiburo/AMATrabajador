package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Cliente_Actividad {

    static int id_Cliente;
    static int id_Actividad;

    public Cliente_Actividad(int id_ClienteTitular, int id_Actividad) {
        this.id_Cliente = id_ClienteTitular;
        this.id_Actividad = id_Actividad;
    }

    public static int getId_Cliente() {
        return id_Cliente;
    }

    public static int getId_Actividad() {
        return id_Actividad;
    }

    public static void setId_Cliente(int id_Cliente) {
        Cliente_Actividad.id_Cliente = id_Cliente;
    }

    public static void setId_Actividad(int id_Actividad) {
        Cliente_Actividad.id_Actividad = id_Actividad;
    }
    
    

    static void insertar(Cliente_Actividad cliente_Actividad) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Cliente_Actividad (ClienteID_Cliente, ActividadID_Actividad) "
                    + "VALUES (" + cliente_Actividad.id_Cliente + ", " + cliente_Actividad.id_Actividad + ");";

            stmt.executeUpdate(sql);

            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<Cliente_Actividad> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<Cliente_Actividad> lista = new ArrayList<Cliente_Actividad>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente_Actividad;");
            while (rs.next()) {
                int id_ClienteTitular = rs.getInt("id_ClienteTitular");
                int id_Actividad = rs.getInt("id_Actividad");
                Cliente_Actividad cliente_Actividad = new Cliente_Actividad(id_ClienteTitular, id_Actividad);
                lista.add(cliente_Actividad);

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

    static void actualizar(Cliente_Actividad cliente_Actividad, int id_ClienteTitularOld, int id_ActividadOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            int id_ClienteTitular = cliente_Actividad.id_Cliente;
            int id_Actividad = cliente_Actividad.id_Actividad;
            String sql = "UPDATE Cliente_Actividad set "
                    + "ClienteID_Cliente=" + id_ClienteTitular + " , "
                    + "ActividadID_Actividad=" + id_Actividad + " "
                    + "where ClienteID_Cliente=" + id_ClienteTitularOld + " and "
                    + "ActividadID_Actividad=" + id_ActividadOld + " ;";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static void eliminar(int id_ClienteTitular, int id_Actividad) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE from Cliente_Actividad where "
                    + "ClienteID_Cliente = " + id_ClienteTitular + " "
                    + "and ActividadID_Actividad = " + id_Actividad + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

}
