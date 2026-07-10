package controller;

import model.Purchase;
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

}