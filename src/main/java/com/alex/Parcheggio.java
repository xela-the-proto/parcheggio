package com.alex;

public class Parcheggio {
    public static final int MAX_NUM_POSTI = 100;
    private Automobile posti[];

    public Parcheggio() {
        posti = new Automobile[MAX_NUM_POSTI];
    }

    public void setAutomobile(Automobile automobile, int posizione) throws ArrayIndexOutOfBoundsException,
            PosizioneOccupata, TargaGiaPresente {

        if (posti[posizione] != null) {
            throw new PosizioneOccupata();
        }
        for (int i = 0; i < posti.length; i++) {
            if (posti[i].getTarga().equals(automobile.getTarga())) {
                throw new TargaGiaPresente();
            }
        }
        posti[posizione] = automobile;
    }
    public Automobile getAutomobile(int posizione)throws ArrayIndexOutOfBoundsException{
        return posti[posizione];
    }
    public void rimuoviAutomobili(int posizione) throws ArrayIndexOutOfBoundsException{
        posti[posizione] = null;    
    }

}
