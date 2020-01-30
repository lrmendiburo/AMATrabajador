package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Ingreso {

    static String concepto;
    static float monto;
    static String mes;
    static String fecha;
    static String nota;
    static int id_Oficina;

    public Ingreso(String concepto, float monto, String mes, String fecha, String nota, int id_Oficina) {
        this.concepto = concepto;
        this.monto = monto;
        this.mes = mes;
        this.fecha = fecha;
        this.nota = nota;
        this.id_Oficina = id_Oficina;
    }

    public static String getConcepto() {
        return concepto;
    }

    public static float getMonto() {
        return monto;
    }

    public static String getMes() {
        return mes;
    }

    public static String getFecha() {
        return fecha;
    }

    public static String getNota() {
        return nota;
    }

    public static int getId_Oficina() {
        return id_Oficina;
    }

    public static void setConcepto(String concepto) {
        Ingreso.concepto = concepto;
    }

    public static void setMonto(float monto) {
        Ingreso.monto = monto;
    }

    public static void setMes(String mes) {
        Ingreso.mes = mes;
    }

    public static void setFecha(String fecha) {
        Ingreso.fecha = fecha;
    }

    public static void setNota(String nota) {
        Ingreso.nota = nota;
    }

    public static void setId_Oficina(int id_Oficina) {
        Ingreso.id_Oficina = id_Oficina;
    }
    
    

    public static void insertar(Ingreso ingreso) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Ingreso (Concepto,Monto,Mes,Fecha,Nota,OficinaID_Oficina) "
                    + "VALUES ('" + ingreso.concepto + "', " + ingreso.monto + ","
                    + " '" + ingreso.mes + "', '" + ingreso.fecha + "', '" + ingreso.nota + "', " + ingreso.id_Oficina + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Ingreso> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<Ingreso> lista = new ArrayList<Ingreso>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Ingreso;");
            while (rs.next()) {
                String concepto = rs.getString("concepto");
                float monto = rs.getFloat("monto");
                String mes = rs.getString("mes");
                String fecha = rs.getString("fecha");
                String nota = rs.getString("nota");
                int id_Oficina = rs.getInt("id_Oficina");
                Ingreso ingreso = new Ingreso( concepto, monto, mes, fecha, nota, id_Oficina);
                lista.add(ingreso);
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

    public static void actualizar(Ingreso ingreso, int Id_IngresoOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String concepto = ingreso.concepto;
            float monto = ingreso.monto;
            String mes = ingreso.mes;
            String fecha = ingreso.fecha;
            String nota = ingreso.nota;
            int id_Oficina = ingreso.id_Oficina;
            String sql = "UPDATE Ingreso set Concepto='" + concepto + "' , " + " , Monto=" + monto + " , "
                    + "Mes='" + mes + "' , Fecha='" + fecha + "' , Nota='" + nota + "', OficinaID_Oficina=" + id_Oficina + " "
                    + "where Id_Gasto=" + Id_IngresoOld + " ;";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void eliminar(int Id_Ingreso) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE from Ingreso where Id_Ingreso = " + Id_Ingreso + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Ingreso> buscarXFecha(String fecha) {
        ArrayList<Ingreso> lista = leer();
        ArrayList<Ingreso> listaF = new ArrayList<Ingreso>();
        for (Ingreso i : lista) {
            if (i.fecha.equals(fecha)) {
                listaF.add(i);
            }
        }
        return listaF;
    }

    public static int contarIngreso() {
        int cantidad = 0;
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT (*) FROM Ingreso;");
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
