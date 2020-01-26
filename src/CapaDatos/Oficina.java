package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Oficina {

    int id_Oficina;
    String nombre;
    String direccion;
    String municipio;
    int telefono;

    public Oficina(int id_Oficina, String nombre, String direccion, String municipio, int telefono) {
        this.id_Oficina = id_Oficina;
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.telefono = telefono;
    }

    static void insertar(Oficina oficina) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Oficina (ID_Oficina,Nombre,Direccion,Municipio,Telefono) "
                    + "VALUES (" + oficina.id_Oficina + ", '" + oficina.nombre + "' ,"
                    + " '" + oficina.direccion + "', '" + oficina.municipio + "', " + oficina.telefono + ");";

            stmt.executeUpdate(sql);

            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<Oficina> leer() {
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

    static void actualizar(Oficina oficina, int id_OficinaOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            int id_Oficina = oficina.id_Oficina;
            String nombre = oficina.nombre;
            String direccion = oficina.direccion;
            String municipio = oficina.municipio;
            int telefono = oficina.telefono;
            String sql = "UPDATE Oficina set ID_Oficina=" + id_Oficina + " , Nombre='" + nombre + "' , "
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

    static void eliminar(int id_Oficina) {
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

    static ArrayList<Oficina> buscarXFecha(String nombre) {
        ArrayList<Oficina> lista = leer();
        ArrayList<Oficina> listaF = new ArrayList<Oficina>();
        for (Oficina o : lista) {
            if (o.nombre.equals(nombre)) {
                listaF.add(o);
            }
        }
        return listaF;
    }

    public int contarOficina() {
        int cantidad = 0;
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT * FROM Oficina;");
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
