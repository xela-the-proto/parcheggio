package com.alex;

public class PosizioneOccupata extends Exception {
    private int posizione;

    public PosizioneOccupata(int posizione) {
        this.posizione = posizione;
    }

    public int getPosizione() {
        return posizione;
    }
}
