package CapaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.prefs.Preferences;

public class CreandoBaseDatos {

    static Preferences preferences = Preferences.userNodeForPackage(CreandoBaseDatos.class);

    public static void main(String args[]) {
        creandoBD();
        crearTablas();
    }

    static void crarTodo() {
        boolean verdadero = preferences.getBoolean("verdadero", true);
        if (!verdadero) {
            creandoBD();
            crearTablas();
            preferences.putBoolean("verdadero", true);
        } else {
            System.out.println("Ya esta todo creado");
        }
    }

    static void creandoBD() {
        Connection cnx;
        PreparedStatement ps;
        try {
            cnx = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "1234");
            ps = cnx.prepareStatement("CREATE DATABASE \"AMADB\"\n"
                    + "    WITH \n"
                    + "    OWNER = postgres\n"
                    + "    ENCODING = 'UTF8'\n"
                    + "    LC_COLLATE = 'Spanish_Spain.1252'\n"
                    + "    LC_CTYPE = 'Spanish_Spain.1252'\n"
                    + "    TABLESPACE = pg_default\n"
                    + "    CONNECTION LIMIT = -1;");
            ps.executeUpdate();
            ps.close();
            cnx.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    static Connection conectando(String host, String port, String database, String user, String password) {

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://" + host + ":" + port + "/" + database + "",
                            "" + user + "", "" + password + "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    static void crearTablas() {
        Connection connection = conectando("localhost", "5432", "AMADB", "postgres", "1234");
        Statement stmt = null;
        try {

            stmt = connection.createStatement();
            String sql = "CREATE TABLE Oficina (\n"
                    + "  ID_Oficina SERIAL NOT NULL, \n"
                    + "  Nombre     varchar(50) NOT NULL, \n"
                    + "  Direccion  varchar(50) NOT NULL, \n"
                    + "  Municipio  varchar(50) NOT NULL, \n"
                    + "  Telefono   int4, \n"
                    + "  PRIMARY KEY (ID_Oficina));\n"
                    + "CREATE TABLE Trabajador (\n"
                    + "  ID_Trabajador     SERIAL NOT NULL, \n"
                    + "  Nombre            varchar(50) NOT NULL, \n"
                    + "  Apellido          varchar(50) NOT NULL, \n"
                    + "  Salario           float4 NOT NULL, \n"
                    + "  Telefono1         int4, \n"
                    + "  Telefono2         int4, \n"
                    + "  OficinaID_Oficina int4 NOT NULL, \n"
                    + "  CredencialUsuario varchar(15) NOT NULL, \n"
                    + "  PRIMARY KEY (ID_Trabajador));\n"
                    + "CREATE TABLE Ingreso (\n"
                    + "  ID_Ingreso        SERIAL NOT NULL, \n"
                    + "  Concepto          varchar(50) NOT NULL, \n"
                    + "  Monto             float4 NOT NULL, \n"
                    + "  Mes               varchar(50) NOT NULL, \n"
                    + "  Fecha             date NOT NULL, \n"
                    + "  Nota              varchar(255), \n"
                    + "  OficinaID_Oficina int4 NOT NULL, \n"
                    + "  PRIMARY KEY (ID_Ingreso));\n"
                    + "CREATE TABLE Gasto (\n"
                    + "  Id_Gasto          SERIAL NOT NULL, \n"
                    + "  Monto             float4 NOT NULL, \n"
                    + "  Mes               varchar(50) NOT NULL, \n"
                    + "  Fecha             date NOT NULL, \n"
                    + "  Nota              varchar(255), \n"
                    + "  OficinaID_Oficina int4 NOT NULL, \n"
                    + "  PRIMARY KEY (Id_Gasto));\n"
                    + "CREATE TABLE Servicio (\n"
                    + "  ID_Servicio       SERIAL NOT NULL, \n"
                    + "  Mes               varchar(50) NOT NULL, \n"
                    + "  Fecha             date NOT NULL, \n"
                    + "  Nota              varchar(255), \n"
                    + "  OficinaID_Oficina int4 NOT NULL, \n"
                    + "  ClienteID_Cliente int4 NOT NULL, \n"
                    + "  PRIMARY KEY (ID_Servicio));\n"
                    + "CREATE TABLE Cliente (\n"
                    + "  ID_Cliente               SERIAL NOT NULL, \n"
                    + "  Nombre                   varchar(50) NOT NULL, \n"
                    + "  Apellido                 varchar(50) NOT NULL, \n"
                    + "  Direccion                varchar(50) NOT NULL, \n"
                    + "  Municipio                varchar(50) NOT NULL, \n"
                    + "  Telefono1                int4, \n"
                    + "  Telefono2                int4, \n"
                    + "  Servicio                 float4, \n"
                    + "  Nota                     varchar(255), \n"
                    + "  Es_Titular               bool NOT NULL, \n"
                    + "  Tiene_Titular            bool NOT NULL, \n"
                    + "  ClienteID_ClienteTitular int4, \n"
                    + "  OficinaID_Oficina        int4 NOT NULL, \n"
                    + "  PRIMARY KEY (ID_Cliente));\n"
                    + "CREATE TABLE Pago (\n"
                    + "  ID_Pago             SERIAL NOT NULL, \n"
                    + "  Concepto            varchar(50) NOT NULL, \n"
                    + "  Monto               float4 NOT NULL, \n"
                    + "  Nota                varchar(255), \n"
                    + "  ServicioID_Servicio int4 NOT NULL, \n"
                    + "  PRIMARY KEY (ID_Pago));\n"
                    + "CREATE TABLE Actividad (\n"
                    + "  ID_Actividad SERIAL NOT NULL, \n"
                    + "  Nombre       varchar(50) NOT NULL, \n"
                    + "  Descripcion  varchar(255), \n"
                    + "  PRIMARY KEY (ID_Actividad));\n"
                    + "CREATE TABLE Credencial (\n"
                    + "  Usuario varchar(15) NOT NULL, \n"
                    + "  Pass    varchar(15) NOT NULL, \n"
                    + "  Nombre  varchar(255) NOT NULL, \n"
                    + "  Rol     varchar(50) NOT NULL, \n"
                    + "  PRIMARY KEY (Usuario));\n"
                    + "CREATE TABLE Cliente_Actividad (\n"
                    + "  ClienteID_Cliente     int4 NOT NULL, \n"
                    + "  ActividadID_Actividad int4 NOT NULL, \n"
                    + "  PRIMARY KEY (ClienteID_Cliente, \n"
                    + "  ActividadID_Actividad));\n"
                    + "CREATE UNIQUE INDEX Oficina_ID_Oficina \n"
                    + "  ON Oficina (ID_Oficina);\n"
                    + "CREATE UNIQUE INDEX Ingreso_ID_Ingreso \n"
                    + "  ON Ingreso (ID_Ingreso);\n"
                    + "CREATE UNIQUE INDEX Gasto_Id_Gasto \n"
                    + "  ON Gasto (Id_Gasto);\n"
                    + "CREATE UNIQUE INDEX Servicio_ID_Servicio \n"
                    + "  ON Servicio (ID_Servicio);\n"
                    + "CREATE UNIQUE INDEX Pago_ID_Pago \n"
                    + "  ON Pago (ID_Pago);\n"
                    + "ALTER TABLE Pago ADD CONSTRAINT FKPago583528 FOREIGN KEY (ServicioID_Servicio) REFERENCES Servicio (ID_Servicio);\n"
                    + "ALTER TABLE Trabajador ADD CONSTRAINT FKTrabajador355270 FOREIGN KEY (OficinaID_Oficina) REFERENCES Oficina (ID_Oficina);\n"
                    + "ALTER TABLE Ingreso ADD CONSTRAINT FKIngreso721159 FOREIGN KEY (OficinaID_Oficina) REFERENCES Oficina (ID_Oficina);\n"
                    + "ALTER TABLE Gasto ADD CONSTRAINT FKGasto264628 FOREIGN KEY (OficinaID_Oficina) REFERENCES Oficina (ID_Oficina);\n"
                    + "ALTER TABLE Servicio ADD CONSTRAINT FKServicio16365 FOREIGN KEY (OficinaID_Oficina) REFERENCES Oficina (ID_Oficina);\n"
                    + "ALTER TABLE Cliente ADD CONSTRAINT FKCliente404682 FOREIGN KEY (OficinaID_Oficina) REFERENCES Oficina (ID_Oficina);\n"
                    + "ALTER TABLE Cliente ADD CONSTRAINT FKCliente239195 FOREIGN KEY (ClienteID_ClienteTitular) REFERENCES Cliente (ID_Cliente);\n"
                    + "ALTER TABLE Servicio ADD CONSTRAINT FKServicio582109 FOREIGN KEY (ClienteID_Cliente) REFERENCES Cliente (ID_Cliente);\n"
                    + "ALTER TABLE Trabajador ADD CONSTRAINT FKTrabajador656514 FOREIGN KEY (CredencialUsuario) REFERENCES Credencial (Usuario);\n"
                    + "ALTER TABLE Cliente_Actividad ADD CONSTRAINT FKCliente_Ac727178 FOREIGN KEY (ClienteID_Cliente) REFERENCES Cliente (ID_Cliente);\n"
                    + "ALTER TABLE Cliente_Actividad ADD CONSTRAINT FKCliente_Ac420616 FOREIGN KEY (ActividadID_Actividad) REFERENCES Actividad (ID_Actividad);";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
