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
    int id_ClienteTitular;
    int id_ClienteContratado;

    public Servicio(int id_Servicio, String mes, Date fecha, String nota, int id_Oficina, int id_ClienteTitular, int id_ClienteContratado) {
        this.id_Servicio = id_Servicio;
        this.mes = mes;
        this.fecha = fecha;
        this.nota = nota;
        this.id_Oficina = id_Oficina;
        this.id_ClienteTitular = id_ClienteTitular;
        this.id_ClienteContratado = id_ClienteContratado;
    }

    static void insertar(Servicio servicio) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Servicio (ID_Servicio,Mes,Fecha,Nota,OficinaID_Oficina,Cliente_TitularID_ClienteTitular,Cliente_ContratadoID_ClienteContratado) "
                    + "VALUES (" + servicio.id_Servicio + ", '" + servicio.mes + "' ,"
                    + " " + servicio.fecha + ", '" + servicio.nota + "', " + servicio.id_Oficina +
                     ", " + servicio.id_ClienteTitular + ", " + servicio.id_ClienteContratado +");";

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
                int id_ClienteTitular = rs.getInt("id_ClienteTitular");
                int id_ClienteContratado = rs.getInt("id_ClienteContratado");
                Servicio servicio = new Servicio(id_Servicio, mes, fecha, nota, id_Oficina,id_ClienteTitular,id_ClienteContratado);
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
            int id_Servicio = servicio.id_Servicio;
            String mes = servicio.mes;
            Date fecha = servicio.fecha;
            String nota = servicio.nota;
            int id_Oficina = servicio.id_Oficina;
            int id_ClienteTitular = servicio.id_ClienteTitular;
            int id_ClienteContratado = servicio.id_ClienteContratado;
            String sql = "UPDATE Servicio set ID_Servicio=" + id_Servicio + " , Mes='" + mes + "' , "
                    + "Fecha=" + fecha + " , Nota='" + nota + "', OficinaID_Oficina=" + id_Oficina +
                    ", Cliente_TitularID_ClienteTitular=" + id_ClienteTitular +", Cliente_ContratadoID_ClienteContratado=" + id_ClienteContratado +" "
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

}
