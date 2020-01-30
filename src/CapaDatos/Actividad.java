package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Actividad {

    static int id_Actividad;
    static String nombre;
    static String descripcion;

    public Actividad(int id_Actividad, String nombre, String descripcion) {
        this.id_Actividad = id_Actividad;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public static int getId_Actividad() {
        return id_Actividad;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getDescripcion() {
        return descripcion;
    }

    public static void setId_Actividad(int id_Actividad) {
        Actividad.id_Actividad = id_Actividad;
    }

    public static void setNombre(String nombre) {
        Actividad.nombre = nombre;
    }

    public static void setDescripcion(String descripcion) {
        Actividad.descripcion = descripcion;
    }

    
    
    public static void insertar(Actividad actividad) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Actividad (Nombre,Descripcion) "
                    + "VALUES ('" + actividad.nombre + "', '" + actividad.descripcion + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Actividad> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<Actividad> lista = new ArrayList<Actividad>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Actividad;");
            while (rs.next()) {
                int id_Actividad = rs.getInt("id_Actividad");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descrpcion");
                Actividad actividad = new Actividad(id_Actividad, nombre, descripcion);
                lista.add(actividad);
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

    public static void actualizar(Actividad actividad, int ID_ActividadOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String nombre = actividad.nombre;
            String descripcion = actividad.descripcion;
            String sql = "UPDATE Actividad set Nombre='" + nombre + "', Descripcion='" + descripcion + "' where ID_Actividad=" + ID_ActividadOld + " ;";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void eliminar(int ID_Actividad) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE from Actividad where ID_Actividad = " + ID_Actividad + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Actividad> buscarXNombre(String nombre) {
        ArrayList<Actividad> lista = leer();
        ArrayList<Actividad> listaF = new ArrayList<Actividad>();
        for (Actividad a : lista) {
            if (a.nombre.equals(nombre)) {
                listaF.add(a);
            }
        }
        return listaF;
    }

    public int contarActividad() {
        int cantidad = 0;
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT (*) FROM Actividad;");
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
