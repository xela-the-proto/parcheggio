package com.alex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        InputStreamReader lettore = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(lettore);
        String scelta = "";

        try {
            Parcheggio parcheggio = new Parcheggio();
            parcheggio.caricaParcheggio();
        } catch (FileNotFoundException e) {
            System.out.println("file non trovato");
        } catch (IOException e) {
            System.out.println("file danneggiato il programma si chiudera' per evitare la corruzione dei dati");

            System.exit(0);
        }
    }
}
