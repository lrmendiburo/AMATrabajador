package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Pago {

    int id_Pago;
    String concepto;
    float monto;
    String nota;
    int id_Servicio;

    public Pago(int id_Pago, String concepto, float monto, String nota, int id_Servicio) {
        this.id_Pago = id_Pago;
        this.concepto = concepto;
        this.monto = monto;
        this.nota = nota;
        this.id_Servicio = id_Servicio;
    }

    static void insertar(Pago pago) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Pago (ID_Pago,Concepto,Monto,Nota,ServicioID_Servicio) "
                    + "VALUES (" + pago.id_Pago + ", '" + pago.concepto + "' ,"
                    + " " + pago.monto + ", '" + pago.nota + "', " + pago.id_Servicio + ");";

            stmt.executeUpdate(sql);

            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<Pago> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<Pago> lista = new ArrayList<Pago>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Pago;");
            while (rs.next()) {
                int id_Pago = rs.getInt("id_Pago");
                String concepto = rs.getString("concepto");
                float monto = rs.getFloat("monto");
                String nota = rs.getString("nota");
                int id_Servicio = rs.getInt("telefono");
                Pago pago = new Pago(id_Pago, concepto, monto, nota, id_Servicio);
                lista.add(pago);

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

    static void actualizar(Pago pago, int id_PagoOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            int id_Pago = pago.id_Pago;
            String concepto = pago.concepto;
            float monto = pago.monto;
            String nota = pago.nota;
            int id_Servicio = pago.id_Servicio;
            String sql = "UPDATE Pago set ID_Pago=" + id_Pago + " , Concepto='" + concepto + "' , "
                    + "Monto=" + monto + " , Nota='" + nota + "', ServicioID_Servicio=" + id_Servicio + " "
                    + "where ID_Pago=" + id_PagoOld + " ;";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static void eliminar(int id_Pago) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE from Pago where ID_Pago = " + id_Pago + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<Pago> buscarXFecha(int id_Servicio) {
        ArrayList<Pago> lista = leer();
        ArrayList<Pago> listaF = new ArrayList<Pago>();
        for (Pago p : lista) {
            if (p.id_Servicio == id_Servicio) {
                listaF.add(p);
            }
        }
        return listaF;
    }

}
