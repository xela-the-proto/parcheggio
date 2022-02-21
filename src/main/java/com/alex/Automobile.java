package com.alex;

public class Automobile {
    private
    String targa;
    String marca;
    String modello;

    

    public Automobile(String targa, String marca, String modello){
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
    }

    public String getTarga() {
        return this.targa;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModello() {
        return this.modello;
    }

    public String toString(){
        return "targa:" + targa + "\nmarca:" + marca + "\nmodello" + modello; 
    }

}

