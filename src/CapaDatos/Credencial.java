package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Credencial {

    String usuario;
    String pass;
    String nombre;
    String rol;

    public Credencial(String usuario, String pass, String nombre, String rol) {
        this.usuario = usuario;
        this.pass = pass;
        this.nombre = nombre;
        this.rol = rol;
    }

    static void insertar(Credencial credencial) {
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

    static ArrayList<Credencial> leer() {
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

    static void actualizar(Credencial credencial, String usuarioOld) {
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

    static void eliminar(String Usuario) {
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

    static ArrayList<Credencial> buscarXNombre(String nombre) {
        ArrayList<Credencial> lista = leer();
        ArrayList<Credencial> listaF = new ArrayList<Credencial>();
        for (Credencial c : lista) {
            if (c.nombre.equals(nombre)) {
                listaF.add(c);
            }
        }
        return listaF;
    }

    public int contarCredencial() {
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
