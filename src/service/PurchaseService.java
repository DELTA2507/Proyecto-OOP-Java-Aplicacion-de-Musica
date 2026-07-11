package service;

import model.Datos;
import model.Purchase;
import model.role.Customer;

import java.util.ArrayList;
import java.util.List;

public class PurchaseService {

    private Datos datos;

    public PurchaseService(Datos datos) {
        this.datos = datos;
    }

    public List<Purchase> listarCompras() {
        return datos.getPurchases();
    }

    public List<Purchase> listarComprasPorCustomer(Customer customer) {
        List<Purchase> resultado = new ArrayList<>();

        if (customer == null) {
            return resultado;
        }

        for (Purchase purchase : datos.getPurchases()) {
            if (purchase.getCustomer().equals(customer)) {
                resultado.add(purchase);
            }
        }

        return resultado;
    }
}