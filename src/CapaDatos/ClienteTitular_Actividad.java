package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteTitular_Actividad {

    int id_ClienteTitular;
    int id_Actividad;

    public ClienteTitular_Actividad(int id_ClienteTitular, int id_Actividad) {
        this.id_ClienteTitular = id_ClienteTitular;
        this.id_Actividad = id_Actividad;
    }

    static void insertar(ClienteTitular_Actividad clienteTitular_Actividad) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Cliente_Titular_Actividad (Cliente_TitularID_ClienteTitular, ActividadID_Actividad) "
                    + "VALUES (" + clienteTitular_Actividad.id_ClienteTitular + ", " + clienteTitular_Actividad.id_Actividad + ");";

            stmt.executeUpdate(sql);

            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<ClienteTitular_Actividad> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<ClienteTitular_Actividad> lista = new ArrayList<ClienteTitular_Actividad>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente_Titular_Actividad;");
            while (rs.next()) {
                int id_ClienteTitular = rs.getInt("id_ClienteTitular");
                int id_Actividad = rs.getInt("id_Actividad");
                ClienteTitular_Actividad clienteTitular_Actividad = new ClienteTitular_Actividad(id_ClienteTitular, id_Actividad);
                lista.add(clienteTitular_Actividad);

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

    static void actualizar(ClienteTitular_Actividad clienteTitular_Actividad, int id_ClienteTitularOld, int id_ActividadOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            int id_ClienteTitular = clienteTitular_Actividad.id_ClienteTitular;
            int id_Actividad = clienteTitular_Actividad.id_Actividad;
            String sql = "UPDATE Cliente_Titular_Actividad set "
                    + "Cliente_TitularID_ClienteTitular=" + id_ClienteTitular + " , "
                    + "ActividadID_Actividad=" + id_Actividad + " "
                    + "where Cliente_TitularID_ClienteTitular=" + id_ClienteTitularOld + " and "
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
            String sql = "DELETE from Cliente_Titular_Actividad where "
                    + "Cliente_TitularID_ClienteTitular = " + id_ClienteTitular + " "
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
