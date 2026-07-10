package service;

import model.Datos;
import model.Purchase;

import java.util.List;

public class PurchaseService {

    private Datos datos;

    public PurchaseService(Datos datos) {
        this.datos = datos;
    }

    public List<Purchase> listarCompras() {
        return datos.getPurchases();
    }

    TopService topService = new TopService(datos);
}