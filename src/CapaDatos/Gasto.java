package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Gasto {

    static int id_Gasto;
    static float monto;
    static String mes;
    static Date fecha;
    static String nota;
    static int id_Oficina;

    public Gasto(int id_Gasto, float monto, String mes, Date fecha, String nota, int id_Oficina) {
        this.id_Gasto = id_Gasto;
        this.monto = monto;
        this.mes = mes;
        this.fecha = fecha;
        this.nota = nota;
        this.id_Oficina = id_Oficina;
    }

    public static int getId_Gasto() {
        return id_Gasto;
    }

    public static float getMonto() {
        return monto;
    }

    public static String getMes() {
        return mes;
    }

    public static Date getFecha() {
        return fecha;
    }

    public static String getNota() {
        return nota;
    }

    public static int getId_Oficina() {
        return id_Oficina;
    }

    public static void setId_Gasto(int id_Gasto) {
        Gasto.id_Gasto = id_Gasto;
    }

    public static void setMonto(float monto) {
        Gasto.monto = monto;
    }

    public static void setMes(String mes) {
        Gasto.mes = mes;
    }

    public static void setFecha(Date fecha) {
        Gasto.fecha = fecha;
    }

    public static void setNota(String nota) {
        Gasto.nota = nota;
    }

    public static void setId_Oficina(int id_Oficina) {
        Gasto.id_Oficina = id_Oficina;
    }
    
    

    public static void insertar(Gasto gasto) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Gasto (Monto,Mes,Fecha,Nota,OficinaID_Oficina) "
                    + "VALUES (" + gasto.monto + ",'" + gasto.mes + "',"
                    + " " + gasto.fecha + ", '" + gasto.nota + "', " + gasto.id_Oficina + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Gasto> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<Gasto> lista = new ArrayList<Gasto>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Gasto;");
            while (rs.next()) {
                int id_Gasto = rs.getInt("id_Gasto");
                float monto = rs.getFloat("monto");
                String mes = rs.getString("mes");
                Date fecha = rs.getDate("fecha");
                String nota = rs.getString("nota");
                int id_Oficina = rs.getInt("id_Oficina");
                Gasto gasto = new Gasto(id_Gasto, monto, mes, fecha, nota, id_Oficina);
                lista.add(gasto);

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

    public static void actualizar(Gasto gasto, int Id_GastoOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            float monto = gasto.monto;
            String mes = gasto.mes;
            Date fecha = gasto.fecha;
            String nota = gasto.nota;
            int id_Oficina = gasto.id_Oficina;
            String sql = "UPDATE Gasto set Monto=" + monto + " , Mes='" + mes + "' , "
                    + "Fecha=" + fecha + " , Nota='" + nota + "', OficinaID_Oficina=" + id_Oficina + " "
                    + "where Id_Gasto=" + Id_GastoOld + " ;";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void eliminar(int Id_Gasto) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE from Gasto where Id_Gasto = " + Id_Gasto + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Gasto> buscarXFecha(Date fecha) {
        ArrayList<Gasto> lista = leer();
        ArrayList<Gasto> listaF = new ArrayList<Gasto>();
        for (Gasto g : lista) {
            if (g.fecha.equals(fecha)) {
                listaF.add(g);
            }
        }
        return listaF;
    }

    public static int contarGasto() {
        int cantidad = 0;
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT (*) FROM Gasto;");
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
