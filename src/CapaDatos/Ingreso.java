package CapaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Ingreso {

    int id_Ingreso;
    String concepto;
    float monto;
    String mes;
    Date fecha;
    String nota;
    int id_Oficina;

    public Ingreso(int id_Ingreso, String concepto, float monto, String mes, Date fecha, String nota, int id_Oficina) {
        this.id_Ingreso = id_Ingreso;
        this.concepto = concepto;
        this.monto = monto;
        this.mes = mes;
        this.fecha = fecha;
        this.nota = nota;
        this.id_Oficina = id_Oficina;
    }

    static void insertar(Ingreso ingreso) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO Ingreso (ID_Ingreso,Concepto,Monto,Mes,Fecha,Nota,OficinaID_Oficina) "
                    + "VALUES (" + ingreso.id_Ingreso + ", '" + ingreso.concepto + "', " + ingreso.monto + ","
                    + " '" + ingreso.mes + "', "+ ingreso.fecha + ", '" + ingreso.nota + "', " + ingreso.id_Oficina + ");";

            stmt.executeUpdate(sql);

            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static ArrayList<Ingreso> leer() {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        ArrayList<Ingreso> lista = new ArrayList<Ingreso>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Ingreso;");
            while (rs.next()) {
                int id_Ingreso = rs.getInt("id_Ingreso");
                String concepto = rs.getString("concepto");
                float monto = rs.getFloat("monto");
                String mes = rs.getString("mes");
                Date fecha = rs.getDate("fecha");
                String nota = rs.getString("nota");
                int id_Oficina = rs.getInt("id_Oficina");
                Ingreso ingreso = new Ingreso(id_Ingreso, concepto, monto, mes, fecha, nota, id_Oficina);
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

    static void actualizar(Ingreso ingreso, int Id_IngresoOld) {
        Connection connection = CreandoBaseDatos.conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            int id_Ingreso = ingreso.id_Ingreso;
            String concepto = ingreso.concepto;
            float monto = ingreso.monto;
            String mes = ingreso.mes;
            Date fecha = ingreso.fecha;
            String nota = ingreso.nota;
            int id_Oficina = ingreso.id_Oficina;
            String sql = "UPDATE Ingreso set ID_Ingreso=" + id_Ingreso + " , Concepto='" + concepto + "' , " + " , Monto=" + monto + " , "
                    + "Mes='" + mes + "' , Fecha=" + fecha + " , Nota='" + nota + "', OficinaID_Oficina=" + id_Oficina + " "
                    + "where Id_Gasto=" + Id_IngresoOld + " ;";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    static void eliminar(int Id_Ingreso) {
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

    static ArrayList<Ingreso> buscarXFecha(Date fecha) {
        ArrayList<Ingreso> lista = leer();
        ArrayList<Ingreso> listaF = new ArrayList<Ingreso>();
        for (Ingreso i : lista) {
            if (i.fecha.equals(fecha)) {
                listaF.add(i);
            }
        }
        return listaF;
    }

}
