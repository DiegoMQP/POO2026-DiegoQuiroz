package edu.diego.quiroz.actividad1.process;

import edu.diego.quiroz.actividad1.process.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDatos {
    private static BaseDatos instancia;
    private Connection conexion;
    private static final String DB_URL = "jdbc:sqlite:tecminuevos.db";
    
    private BaseDatos() {
        try {
            conexion = DriverManager.getConnection(DB_URL);
            crearTablas();
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
    
    public static BaseDatos getInstancia() {
        if (instancia == null) {
            instancia = new BaseDatos();
        }
        return instancia;
    }
    
    private void crearTablas() throws SQLException {
        String sqlVehiculos = "CREATE TABLE IF NOT EXISTS vehiculos (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "marca TEXT NOT NULL, " +
            "modelo TEXT NOT NULL, " +
            "año INTEGER, " +
            "color TEXT, " +
            "motor TEXT, " +
            "transmision TEXT, " +
            "combustible TEXT, " +
            "pasajeros INTEGER, " +
            "precio REAL, " +
            "tipo TEXT, " +
            "url_imagen TEXT, " +
            "es_nuevo INTEGER, " +
            "kilometraje INTEGER)";
        
        String sqlExtras = "CREATE TABLE IF NOT EXISTS extras (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre TEXT NOT NULL, " +
            "descripcion TEXT, " +
            "precio REAL, " +
            "categoria TEXT)";
        
        String sqlVehiculoExtras = "CREATE TABLE IF NOT EXISTS vehiculo_extras (" +
            "vehiculo_id INTEGER, " +
            "extra_id INTEGER, " +
            "FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id), " +
            "FOREIGN KEY (extra_id) REFERENCES extras(id))";
        
        Statement stmt = conexion.createStatement();
        stmt.execute(sqlVehiculos);
        stmt.execute(sqlExtras);
        stmt.execute(sqlVehiculoExtras);
        stmt.close();
    }
    
    public void guardarVehiculo(Vehiculo vehiculo) throws SQLException {
        String sql = "INSERT INTO vehiculos (marca, modelo, año, color, motor, transmision, " +
                    "combustible, pasajeros, precio, tipo, url_imagen, es_nuevo, kilometraje) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pstmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, vehiculo.getMarca());
        pstmt.setString(2, vehiculo.getModelo());
        pstmt.setInt(3, vehiculo.getAño());
        pstmt.setString(4, vehiculo.getColor());
        pstmt.setString(5, vehiculo.getMotor());
        pstmt.setString(6, vehiculo.getTransmision());
        pstmt.setString(7, vehiculo.getCombustible());
        pstmt.setInt(8, vehiculo.getPasajeros());
        pstmt.setDouble(9, vehiculo.getPrecio());
        pstmt.setString(10, vehiculo.getTipo());
        pstmt.setString(11, vehiculo.getUrlImagen());
        
        if (vehiculo instanceof VehiculoNuevo) {
            VehiculoNuevo vn = (VehiculoNuevo) vehiculo;
            pstmt.setInt(12, 1);
            pstmt.setNull(13, Types.INTEGER);
        } else if (vehiculo instanceof VehiculoSeminuevo) {
            VehiculoSeminuevo vs = (VehiculoSeminuevo) vehiculo;
            pstmt.setInt(12, 0);
            pstmt.setInt(13, vs.getKilometraje());
        }
        
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    public List<Vehiculo> obtenerTodosVehiculos() throws SQLException {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM vehiculos";
        
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()) {
            Vehiculo vehiculo;
            boolean esNuevo = rs.getInt("es_nuevo") == 1;
            
            if (esNuevo) {
                vehiculo = new VehiculoNuevo(
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("año"),
                    rs.getString("color"),
                    rs.getString("motor"),
                    rs.getString("transmision"),
                    rs.getString("combustible"),
                    rs.getInt("pasajeros"),
                    rs.getDouble("precio"),
                    rs.getString("tipo"),
                    rs.getString("url_imagen")
                );
            } else {
                vehiculo = new VehiculoSeminuevo(
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("año"),
                    rs.getString("color"),
                    rs.getString("motor"),
                    rs.getString("transmision"),
                    rs.getString("combustible"),
                    rs.getInt("pasajeros"),
                    rs.getDouble("precio"),
                    rs.getString("tipo"),
                    rs.getString("url_imagen"),
                    rs.getInt("kilometraje")
                );
            }
            vehiculos.add(vehiculo);
        }
        
        rs.close();
        stmt.close();
        return vehiculos;
    }
    
    public void guardarExtra(Extra extra) throws SQLException {
        String sql = "INSERT INTO extras (nombre, descripcion, precio, categoria) VALUES (?, ?, ?, ?)";
        
        PreparedStatement pstmt = conexion.prepareStatement(sql);
        pstmt.setString(1, extra.getNombre());
        pstmt.setString(2, extra.getDescripcion());
        pstmt.setDouble(3, extra.getPrecio());
        pstmt.setString(4, extra.getCategoria());
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    public void cerrar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la base de datos: " + e.getMessage());
        }
    }
}
