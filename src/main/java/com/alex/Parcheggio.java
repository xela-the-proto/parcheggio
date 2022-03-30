package com.alex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

	public void salvaAutomobile() throws IOException {
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("parcheggio.bin"));
		stream.writeObject(this.posti);
		stream.close();
	}

	public void caricaParcheggio() throws IOException, FileNotFoundException {
		ObjectInputStream stream = new ObjectInputStream(new FileInputStream("parcheggio.bin"));

		try {
			this.posti = (Automobile[]) stream.readObject();
		} catch (ClassNotFoundException e) {
			System.out.println("classe non trovata");
		}
		stream.close();
	}

}
