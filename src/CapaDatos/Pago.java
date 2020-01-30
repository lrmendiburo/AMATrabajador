package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Pago {

    static int id_Pago;
    static String concepto;
    static float monto;
    static String nota;
    static int id_Servicio;

    public Pago(int id_Pago, String concepto, float monto, String nota, int id_Servicio) {
        this.id_Pago = id_Pago;
        this.concepto = concepto;
        this.monto = monto;
        this.nota = nota;
        this.id_Servicio = id_Servicio;
    }

    public static int getId_Pago() {
        return id_Pago;
    }

    public static String getConcepto() {
        return concepto;
    }

    public static float getMonto() {
        return monto;
    }

    public static String getNota() {
        return nota;
    }

    public static int getId_Servicio() {
        return id_Servicio;
    }

    public static void setId_Pago(int id_Pago) {
        Pago.id_Pago = id_Pago;
    }

    public static void setConcepto(String concepto) {
        Pago.concepto = concepto;
    }

    public static void setMonto(float monto) {
        Pago.monto = monto;
    }

    public static void setNota(String nota) {
        Pago.nota = nota;
    }

    public static void setId_Servicio(int id_Servicio) {
        Pago.id_Servicio = id_Servicio;
    }
    
    

    public static void insertar(Pago pago) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Pago (Concepto,Monto,Nota,ServicioID_Servicio) "
                    + "VALUES ('" + pago.concepto + "' ,"
                    + pago.monto + ", '" + pago.nota + "', " + pago.id_Servicio + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Pago> leer() {
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
                int id_Servicio = rs.getInt("id_Servicio");
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

    public static void actualizar(Pago pago, int id_PagoOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String concepto = pago.concepto;
            float monto = pago.monto;
            String nota = pago.nota;
            int id_Servicio = pago.id_Servicio;
            String sql = "UPDATE Pago set Concepto='" + concepto + "' , "
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

    public static void eliminar(int id_Pago) {
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

    public static ArrayList<Pago> buscarXFecha(int id_Servicio) {
        ArrayList<Pago> lista = leer();
        ArrayList<Pago> listaF = new ArrayList<Pago>();
        for (Pago p : lista) {
            if (p.id_Servicio == id_Servicio) {
                listaF.add(p);
            }
        }
        return listaF;
    }

    public static int contarPago() {
        int cantidad = 0;
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT (*) FROM Pago;");
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
