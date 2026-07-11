package controller;

import model.Purchase;
import model.role.Customer;
import service.PurchaseService;

import java.util.List;

public class PurchaseController {

    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    public List<Purchase> listarCompras() {
        return purchaseService.listarCompras();
    }

    public List<Purchase> listarComprasPorCustomer(Customer customer) {
        return purchaseService.listarComprasPorCustomer(customer);
    }
}