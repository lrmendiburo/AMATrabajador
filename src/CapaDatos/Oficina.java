package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Oficina {

    static int id_Oficina;
    static String nombre;
    static String direccion;
    static String municipio;
    static int telefono;

    public Oficina(int id_Oficina, String nombre, String direccion, String municipio, int telefono) {
        this.id_Oficina = id_Oficina;
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.telefono = telefono;
    }

    public static int getId_Oficina() {
        return id_Oficina;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getDireccion() {
        return direccion;
    }

    public static String getMunicipio() {
        return municipio;
    }

    public static int getTelefono() {
        return telefono;
    }

    public static void setId_Oficina(int id_Oficina) {
        Oficina.id_Oficina = id_Oficina;
    }

    public static void setNombre(String nombre) {
        Oficina.nombre = nombre;
    }

    public static void setDireccion(String direccion) {
        Oficina.direccion = direccion;
    }

    public static void setMunicipio(String municipio) {
        Oficina.municipio = municipio;
    }

    public static void setTelefono(int telefono) {
        Oficina.telefono = telefono;
    }
    
    
    
    public static void insertar(Oficina oficina) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Oficina (Nombre,Direccion,Municipio,Telefono) "
                    + "VALUES ('" + oficina.nombre + "' ,"
                    + " '" + oficina.direccion + "', '" + oficina.municipio + "', " + oficina.telefono + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Oficina> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<Oficina> lista = new ArrayList<Oficina>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Oficina;");
            while (rs.next()) {
                int id_Oficina = rs.getInt("id_Oficina");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String municipio = rs.getString("municipio");
                int telefono = rs.getInt("telefono");
                Oficina oficina = new Oficina(id_Oficina, nombre, direccion, municipio, telefono);
                lista.add(oficina);
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

    public static void actualizar(Oficina oficina, int id_OficinaOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String nombre = oficina.nombre;
            String direccion = oficina.direccion;
            String municipio = oficina.municipio;
            int telefono = oficina.telefono;
            String sql = "UPDATE Oficina set Nombre='" + nombre + "' , "
                    + "Direccion='" + direccion + "' , Municipio='" + municipio + "', Telefono=" + telefono + " "
                    + "where ID_Oficina=" + id_OficinaOld + " ;";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void eliminar(int id_Oficina) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE from Oficina where ID_Oficina = " + id_Oficina + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Oficina> buscarXNombre(String nombre) {
        ArrayList<Oficina> lista = leer();
        ArrayList<Oficina> listaF = new ArrayList<Oficina>();
        for (Oficina o : lista) {
            if (o.nombre.equals(nombre)) {
                listaF.add(o);
            }
        }
        return listaF;
    }

    public static int contarOficina() {
        int cantidad = 0;
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT (*) FROM Oficina;");
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
