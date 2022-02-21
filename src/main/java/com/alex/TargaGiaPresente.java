package com.alex;

public class TargaGiaPresente extends Exception {
    private String targa;

    public TargaGiaPresente(String targa) {
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }
}
