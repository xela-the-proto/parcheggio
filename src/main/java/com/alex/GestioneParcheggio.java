package com.alex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GestioneParcheggio {
    static Parcheggio parcheggio = new Parcheggio();
    static InputStreamReader lettore = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(lettore);

    public static void parcheggioAutomobile() throws Exception {
        try {
            int posizione;
            String targa;
            String marca;
            String modello;
            String line;

            System.out.println("inserisci la targa: ");
            targa = input.readLine();

            System.out.println("inserisci la marca: ");
            marca = input.readLine();

            System.out.println("inserisci il modello: ");
            modello = input.readLine();

            System.out.println("specifica in che posto vuoi parcheggiare l'auto: ");
            line = input.readLine();
            posizione = Integer.parseInt(line);

            Automobile automobile = new Automobile(targa, marca, modello);

            parcheggio.setAutomobile(automobile, posizione);

            System.out.println("auto parcheggiata con successo!");

        } catch (NumberFormatException e) {
            System.out.println("numero inaccettabile");
        } catch (IOException e) {
            System.out.println("errore IO");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("posizione invalida");
        } catch (PosizioneOccupata e) {
            System.out.println("la posizione " + e.getPosizione() + " e' gia' occupata");
        } catch (TargaGiaPresente e) {
            System.out.println("la targa " + e.getTarga() + " e' gia' presente");
        }

    }

    public static void visualizzazioneAutomobile() throws Exception {
        try {
            int posizione;
            String line;

            System.out.println("specifica la posizioen del parcheggio: ");
            line = input.readLine();
            posizione = Integer.parseInt(line);

            Automobile automobile = parcheggio.getAutomobile(posizione);

            System.out.println(automobile.toString());

        } catch (NumberFormatException e) {
            System.out.println("numero inaccettabile");
        } catch (IOException e) {
            System.out.println("errore IO");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("posizione invalida");
        } catch (NullPointerException e) {
            System.out.println("la posizione specificata e' vuota");
        }

    }

}
