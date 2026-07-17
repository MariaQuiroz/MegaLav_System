package com.megalab.dao;

import com.megalab.database.ConexionMySQL; // Asegura la conexión de tu proyecto
import com.megalab.model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {

    public boolean guardar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (cedula, nombre, apellido, telefono, direccion, email) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionMySQL.getConexion(); // Llama a tu clase de conexión
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, cliente.getCedula());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getEmail());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en ClienteDAO -> guardar: " + e.getMessage());
            throw e;
        }
    }

    public List<Cliente> listarTodos() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes ORDER BY apellido ASC";
        
        try (Connection conn = ConexionMySQL.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("id_cliente"), // Verifica que coincida con el nombre en tu BD
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("email")
                );
                lista.add(c);
            }
        }
        return lista;
    }
}