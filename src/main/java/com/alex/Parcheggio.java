package com.alex;

public class Parcheggio {
    public static final int MAX_NUM_POSTI = 100;
    private Automobile posti[];
    private String targa;

    public Parcheggio() {
        posti = new Automobile[MAX_NUM_POSTI];
    }

    public void setAutomobile(Automobile automobile, int posizione) throws ArrayIndexOutOfBoundsException,
            PosizioneOccupata, TargaGiaPresente {

        if (posti[posizione] != null) {
            throw new PosizioneOccupata(posizione);
        }
        for (int i = 0; i < posti.length; i++) {
            if (posti[i] != null && posti[i].getTarga().equals(automobile.getTarga())) {
                throw new TargaGiaPresente(automobile.getTarga());
            }
        }
        posti[posizione] = automobile;
    }

    public Automobile getAutomobile(int posizione) throws ArrayIndexOutOfBoundsException {
        return posti[posizione];
    }

    public void rimuoviAutomobili(int posizione) throws ArrayIndexOutOfBoundsException {
        posti[posizione] = null;
    }

}
