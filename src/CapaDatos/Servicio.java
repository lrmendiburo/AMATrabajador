package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Servicio {

    int id_Servicio;
    String mes;
    Date fecha;
    String nota;
    int id_Oficina;
    int id_Cliente;

    public Servicio(int id_Servicio, String mes, Date fecha, String nota, int id_Oficina, int id_Cliente) {
        this.id_Servicio = id_Servicio;
        this.mes = mes;
        this.fecha = fecha;
        this.nota = nota;
        this.id_Oficina = id_Oficina;
        this.id_Cliente = id_Cliente;
    }

    static void insertar(Servicio servicio) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Servicio (Mes,Fecha,Nota,OficinaID_Oficina,ClienteID_Cliente) "
                    + "VALUES ('" + servicio.mes + "' ,"
                    + " " + servicio.fecha + ", '" + servicio.nota + "', " + servicio.id_Oficina
                    + ", " + servicio.id_Cliente + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<Servicio> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<Servicio> lista = new ArrayList<Servicio>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Servicio;");
            while (rs.next()) {
                int id_Servicio = rs.getInt("id_Servicio");
                String mes = rs.getString("mes");
                Date fecha = rs.getDate("fecha");
                String nota = rs.getString("nota");
                int id_Oficina = rs.getInt("id_Oficina");
                int id_Cliente = rs.getInt("id_ClienteTitular");
                Servicio servicio = new Servicio(id_Servicio, mes, fecha, nota, id_Oficina, id_Cliente);
                lista.add(servicio);

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

    static void actualizar(Servicio servicio, int id_ServicioOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String mes = servicio.mes;
            Date fecha = servicio.fecha;
            String nota = servicio.nota;
            int id_Oficina = servicio.id_Oficina;
            int id_Cliente = servicio.id_Cliente;
            String sql = "UPDATE Servicio set Mes='" + mes + "' , "
                    + "Fecha=" + fecha + " , Nota='" + nota + "', OficinaID_Oficina=" + id_Oficina
                    + ", ClienteID_Cliente=" + id_Cliente + " "
                    + "where ID_Servicio=" + id_ServicioOld + " ;";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static void eliminar(int id_Servicio) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE from Servicio where ID_Servicio = " + id_Servicio + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<Servicio> buscarXFecha(Date fecha) {
        ArrayList<Servicio> lista = leer();
        ArrayList<Servicio> listaF = new ArrayList<Servicio>();
        for (Servicio s : lista) {
            if (s.fecha.equals(fecha)) {
                listaF.add(s);
            }
        }
        return listaF;
    }

    public int contarServicio() {
        int cantidad = 0;
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT (*) FROM Servicio;");
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
