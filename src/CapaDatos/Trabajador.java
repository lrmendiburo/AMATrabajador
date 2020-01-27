package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Trabajador {

    int id_Trabajador;
    String nombre;
    String apellido;
    float salario;
    int telefono1;
    int telefono2;
    int id_Oficina;
    String usuario;

    public Trabajador(int id_Trabajador, String nombre, String apellido, float salario, int telefono1, int telefono2, int id_Oficina, String usuario) {
        this.id_Trabajador = id_Trabajador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.id_Oficina = id_Oficina;
        this.usuario = usuario;
    }

    static void insertar(Trabajador trabajador) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Trabajador (ID_Trabajador,Nombre,Apellido,Salario,Telefono1,Telefono2,OficinaID_Oficina, CredencialUsuario) "
                    + "VALUES (" + trabajador.id_Trabajador + ", '" + trabajador.nombre + "', '" + trabajador.apellido + "',"
                    + " " + trabajador.salario + ", " + trabajador.telefono1 + ", "
                    + trabajador.telefono2 + ", " + trabajador.id_Oficina + ", '" + trabajador.usuario + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<Trabajador> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<Trabajador> lista = new ArrayList<Trabajador>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Trabajador;");
            while (rs.next()) {
                int id_Trabajador = rs.getInt("id_Trabajador");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                float salario = rs.getFloat("salario");
                int telefono1 = rs.getInt("telefono1");
                int telefono2 = rs.getInt("telefono2");
                int id_Oficina = rs.getInt("id_Oficina");
                String usuario = rs.getString("usuario");
                Trabajador trabajador = new Trabajador(id_Trabajador, nombre, apellido, salario, telefono1, telefono2, id_Oficina, usuario);
                lista.add(trabajador);
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

    static void actualizar(Trabajador trabajador, int Id_TrabajadorOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            int id_Trabajador = trabajador.id_Trabajador;
            String nombre = trabajador.nombre;
            String apellido = trabajador.apellido;
            float salario = trabajador.salario;
            int telefono1 = trabajador.telefono1;
            int telefono2 = trabajador.telefono2;
            int id_Oficina = trabajador.id_Oficina;
            String usuario = trabajador.usuario;
            String sql = "UPDATE Trabajador set ID_Trabajador=" + id_Trabajador + " , Nombre='" + nombre
                    + "' , " + " , Apellido='" + apellido + "' , " + "Salario=" + salario
                    + " , Telefono1='" + telefono1 + "',  Telefono2=" + telefono2 + ""
                    + "  OficinaID_Oficina=" + id_Oficina + "  CredencialUsuario='" + usuario + "' "
                    + "where ID_Trabajador=" + Id_TrabajadorOld + " ;";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static void eliminar(int Id_Trabajador) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE from Trabajador where ID_Trabajador = " + Id_Trabajador + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<Trabajador> buscarXFecha(String nombre) {
        ArrayList<Trabajador> lista = leer();
        ArrayList<Trabajador> listaF = new ArrayList<Trabajador>();
        for (Trabajador t : lista) {
            if (t.nombre.equals(nombre)) {
                listaF.add(t);
            }
        }
        return listaF;
    }

    public int contarTrabajador() {
        int cantidad = 0;
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT (*) FROM Trabajador;");
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
