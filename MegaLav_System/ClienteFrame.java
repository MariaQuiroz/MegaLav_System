private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                           
    try {
        String cedula = txtCedula.getText().trim();
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String email = txtEmail.getText().trim();

        Cliente cliente = new Cliente(cedula, nombre, apellido, telefono, direccion, email);

        ClienteService service = new ClienteService();
        boolean guardadoOk = service.registrarCliente(cliente);

        if (guardadoOk) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "El cliente ha sido registrado correctamente en el sistema.", 
                "Operación Exitosa", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            limpiarFormulario(); // Método que limpia tus inputs de texto
            cargarTablaClientes(); // Método que refresca el JTable con los nuevos datos
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "No se pudo completar el registro del cliente.", 
                "Error en Base de Datos", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    } catch (Exception ex) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Advertencia: " + ex.getMessage(), 
            "Validación fallida", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
    }
}