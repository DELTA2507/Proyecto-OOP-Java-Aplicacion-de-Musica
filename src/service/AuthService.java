package service;

import model.Datos;
import model.User;
import model.role.Admin;
import model.role.Customer;

import java.time.LocalDate;
import java.util.List;

public class AuthService {

    private Datos datos;
    private ValidationService validationService;
    private User usuarioActual;
    private String lastError;

    public AuthService(Datos datos, ValidationService validationService) {
        this.datos = datos;
        this.validationService = validationService;
        this.lastError = "";
    }

    public User login(String username, String password) {
        for (Admin admin : datos.getAdmins()) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                usuarioActual = admin;
                return usuarioActual;
            }
        }

        for (Customer customer : datos.getCustomers()) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                usuarioActual = customer;
                return usuarioActual;
            }
        }

        lastError = "Credenciales incorrectas.";
        return null;
    }

    public boolean registrarCustomer(
            String email,
            String username,
            String password,
            String confirmPassword,
            String fullName,
            String birthDateText,
            String nationality,
            String idNumber,
            String avatar
    ) {
        lastError = "";

        if (existeUsername(username)) {
            lastError = "El nombre de usuario ya existe.";
            return false;
        }

        if (!validationService.passwordsCoinciden(password, confirmPassword)) {
            lastError = "Las contraseñas no coinciden.";
            return false;
        }

        if (!validationService.passwordValida(password)) {
            lastError = "La contraseña debe tener entre 8 y 12 caracteres, una mayúscula, una minúscula, un número y un carácter especial.";
            return false;
        }

        LocalDate birthDate = validationService.parseFechaNacimiento(birthDateText);

        if (birthDate == null) {
            lastError = "La fecha de nacimiento no tiene un formato válido. Use YYYY-MM-DD.";
            return false;
        }

        if (!validationService.esMayorDeEdad(birthDate)) {
            lastError = "El usuario debe ser mayor de edad.";
            return false;
        }

        if (!validationService.nacionalidadPermitida(nationality)) {
            lastError = "La nacionalidad ingresada no está disponible en el servicio.";
            return false;
        }

        String avatarFinal = validationService.normalizarAvatar(avatar);

        Customer customer = new Customer(
                email,
                username,
                password,
                fullName,
                birthDate,
                nationality,
                idNumber,
                avatarFinal,
                4.99
        );

        datos.getCustomers().add(customer);
        usuarioActual = customer;

        return true;
    }

    public boolean existeUsername(String username) {
        for (Admin admin : datos.getAdmins()) {
            if (admin.getUsername().equals(username)) {
                return true;
            }
        }

        for (Customer customer : datos.getCustomers()) {
            if (customer.getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }

    public boolean cambiarPassword(String passwordActual, String nuevaPassword, String confirmPassword) {
        lastError = "";

        if (usuarioActual == null) {
            lastError = "No hay una sesión activa.";
            return false;
        }

        if (!usuarioActual.getPassword().equals(passwordActual)) {
            lastError = "La contraseña actual es incorrecta.";
            return false;
        }

        if (!validationService.passwordsCoinciden(nuevaPassword, confirmPassword)) {
            lastError = "Las nuevas contraseñas no coinciden.";
            return false;
        }

        if (usuarioActual.getPassword().equals(nuevaPassword)) {
            lastError = "La nueva contraseña debe ser distinta a la actual.";
            return false;
        }

        if (!validationService.passwordValida(nuevaPassword)) {
            lastError = "La nueva contraseña debe tener entre 8 y 12 caracteres, una mayúscula, una minúscula, un número y un carácter especial.";
            return false;
        }

        usuarioActual.setPassword(nuevaPassword);
        return true;
    }

    public void logout() {
        usuarioActual = null;
    }

    public User getUsuarioActual() {
        return usuarioActual;
    }

    public Customer getCustomerActual() {
        if (usuarioActual instanceof Customer) {
            return (Customer) usuarioActual;
        }

        return null;
    }

    public Admin getAdminActual() {
        if (usuarioActual instanceof Admin) {
            return (Admin) usuarioActual;
        }

        return null;
    }

    public boolean esAdmin() {
        return usuarioActual instanceof Admin;
    }

    public boolean esCustomer() {
        return usuarioActual instanceof Customer;
    }

    public boolean haySesionActiva() {
        return usuarioActual != null;
    }

    public String getLastError() {
        return lastError;
    }

    public List<String> getNacionalidadesPermitidas() {
        return validationService.getNacionalidadesPermitidas();
    }
}