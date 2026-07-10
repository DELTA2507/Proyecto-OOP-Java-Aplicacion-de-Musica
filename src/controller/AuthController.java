package controller;

import model.User;
import model.role.Admin;
import model.role.Customer;
import service.AuthService;

import java.util.List;

public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public User login(String username, String password) {
        return authService.login(username, password);
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
        return authService.registrarCustomer(
                email,
                username,
                password,
                confirmPassword,
                fullName,
                birthDateText,
                nationality,
                idNumber,
                avatar
        );
    }

    public boolean cambiarPassword(String passwordActual, String nuevaPassword, String confirmPassword) {
        return authService.cambiarPassword(passwordActual, nuevaPassword, confirmPassword);
    }

    public void logout() {
        authService.logout();
    }

    public User getUsuarioActual() {
        return authService.getUsuarioActual();
    }

    public Customer getCustomerActual() {
        return authService.getCustomerActual();
    }

    public Admin getAdminActual() {
        return authService.getAdminActual();
    }

    public boolean esAdmin() {
        return authService.esAdmin();
    }

    public boolean esCustomer() {
        return authService.esCustomer();
    }

    public boolean haySesionActiva() {
        return authService.haySesionActiva();
    }

    public String getLastError() {
        return authService.getLastError();
    }

    public List<String> getNacionalidadesPermitidas() {
        return authService.getNacionalidadesPermitidas();
    }
}