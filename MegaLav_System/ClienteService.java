package com.megalab.service;

import com.megalab.dao.ClienteDAO;
import com.megalab.model.Cliente;
import java.sql.SQLException;
import java.util.List;


public class ClienteService {
    private final ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    
    public boolean registrarCliente(Cliente cliente) throws Exception {
        if (cliente.getCedula() == null || cliente.getCedula().trim().isEmpty()) {
            throw new Exception("La identificación/cédula es mandatoria.");
        }
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del cliente no puede estar vacío.");
        }
        if (cliente.getApellido() == null || cliente.getApellido().trim().isEmpty()) {
            throw new Exception("El apellido del cliente es mandatorio.");
        }
        
        return clienteDAO.guardar(cliente);
    }

    public List<Cliente> obtenerTodosLosClientes() throws SQLException {
        return clienteDAO.listarTodos();
    }
}