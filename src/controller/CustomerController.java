package controller;

import model.Playlist;
import model.role.Customer;
import service.CustomerService;

public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer obtenerClienteActual() {
        return customerService.obtenerClienteActual();
    }

    public Playlist crearPlaylist(String nombre) {
        return customerService.crearPlaylist(nombre);
    }

    public boolean agregarCancionAPlaylist(String idPlaylist, String idCancion) {
        return customerService.agregarCancionAPlaylist(idPlaylist, idCancion);
    }

    public boolean removerCancionDePlaylist(String idPlaylist, String idCancion) {
        return customerService.removerCancionDePlaylist(idPlaylist, idCancion);
    }

    public boolean reproducirPlaylist(String idPlaylist) {
        return customerService.reproducirPlaylist(idPlaylist);
    }

    public boolean agregarFondos(double monto) {
        return customerService.agregarFondos(monto);
    }

    public boolean comprarCancion(String idCancion) {
        return customerService.comprarCancion(idCancion);
    }

    public boolean reproducirCancion(String idCancion) {
        return customerService.reproducirCancion(idCancion);
    }

    public boolean valorarCancion(String idCancion, double valor) {
        return customerService.valorarCancion(idCancion, valor);
    }

    public double calcularRatingPlaylist(String idPlaylist) {
        return customerService.calcularRatingPlaylist(idPlaylist);
    }

    public Customer buscarPorId(String idCustomer) {
        return customerService.buscarPorId(idCustomer);
    }
}