package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Credencial {

    static String usuario;
    static String pass;
    static String nombre;
    static String rol;

    public Credencial(String usuario, String pass, String nombre, String rol) {
        this.usuario = usuario;
        this.pass = pass;
        this.nombre = nombre;
        this.rol = rol;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static String getPass() {
        return pass;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getRol() {
        return rol;
    }

    public static void setUsuario(String usuario) {
        Credencial.usuario = usuario;
    }

    public static void setPass(String pass) {
        Credencial.pass = pass;
    }

    public static void setNombre(String nombre) {
        Credencial.nombre = nombre;
    }

    public static void setRol(String rol) {
        Credencial.rol = rol;
    }
    
    

    public static void insertar(Credencial credencial) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Credencial (Usuario,Pass,Nombre,Rol) "
                    + "VALUES ('" + credencial.usuario + "', '" + credencial.pass + "', '"
                    + credencial.nombre + "', '" + credencial.rol + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Credencial> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<Credencial> lista = new ArrayList<Credencial>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Credencial;");
            while (rs.next()) {
                String usuario = rs.getString("usuario");
                String pass = rs.getString("pass");
                String nombre = rs.getString("nombre");
                String rol = rs.getString("rol");
                Credencial credencial = new Credencial(usuario, pass, nombre, rol);
                lista.add(credencial);
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

    public static void actualizar(Credencial credencial, String usuarioOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String usuario = credencial.usuario;
            String pass = credencial.pass;
            String nombre = credencial.nombre;
            String rol = credencial.rol;
            String sql = "UPDATE Credencial set Usuario=" + usuario + " , "
                    + "Pass='" + pass + "', Nombre='" + nombre + "' , Rol='" + rol + "' "
                    + "where Usuario=" + usuario + " ;";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void eliminar(String Usuario) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE from Credencial where Usuario = " + Usuario + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Credencial> buscarXNombre(String nombre) {
        ArrayList<Credencial> lista = leer();
        ArrayList<Credencial> listaF = new ArrayList<Credencial>();
        for (Credencial c : lista) {
            if (c.nombre.equals(nombre)) {
                listaF.add(c);
            }
        }
        return listaF;
    }

    public static int contarCredencial() {
        int cantidad = 0;
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT (*) FROM Credencial;");
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
