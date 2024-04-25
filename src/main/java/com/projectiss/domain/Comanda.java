package com.projectiss.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Comanda extends Entity{
    private LocalDate datePlaced;
    private float totalPrice;
    private final List<Produs> produse = new ArrayList<>();

    public Comanda() {
        datePlaced = LocalDate.now();
    }

    public LocalDate getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(LocalDate datePlaced) {
        this.datePlaced = datePlaced;
    }

    public void addProdus(Produs produs){
        produse.add(produs);
    }

    public void addProduse(Iterable<Produs> produseIterable){
        for(Produs produs : produseIterable){
            produse.add(produs);
        }
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice() {
        totalPrice = 0;
        for (Produs produs : produse){
            totalPrice+= produs.getPrice();
        }
    }

    public List<Produs> getProduse() {
        return produse;
    }
}
