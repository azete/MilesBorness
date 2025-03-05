package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {

	static Random random = new Random();

	public static <T> T extraire(List<T> liste) {
		if (liste.isEmpty()) {
			throw new IllegalStateException("La liste doit etre vide");
		}
		int index = random.nextInt(liste.size());
		return liste.remove(index);
	}

	public static <T> T extraireAvecIterator(List<T> liste) {
		if (liste.isEmpty()) {
			throw new IllegalStateException("La liste doit etre vide");
		}
		ListIterator<T> iterator = liste.listIterator();
		int index = random.nextInt(liste.size());
		for (int indexe = index; indexe > 0 && iterator.hasNext(); indexe--) {
			iterator.next();
		}
		T element = iterator.next();
		iterator.remove();
		return element;
	}

	public static <T> List<T> melanger(List<T> liste) {
		List<T> newListe = new ArrayList<T>();
		while (!liste.isEmpty()) {
			newListe.add(extraire(liste));
		}
		return newListe;
	}

	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
		if (liste1.size() != liste2.size()) {
			return false;
		}
		for (T elem : liste1) {
			if (Collections.frequency(liste1, elem) != Collections.frequency(liste2, elem))
				return false;

		}
		for (T elem : liste2) {
			if (Collections.frequency(liste2, elem) != Collections.frequency(liste1, elem))
				return false;

		}
		return true;
	}

	public static <T> List<T> rassembler(List<T> liste) {
		List<T> result = new ArrayList<>();
		if (liste.isEmpty()) {
			return result;
		}
		result.add(liste.get(0));
		for (int i = 1; i < liste.size(); i++) {
			if (!liste.get(i).equals(liste.get(i - 1))) {
				result.add(liste.get(i));
			}
		}
		return result;
	}

	public static <T> boolean verifierRassemblement(List<T> liste) {
		if (liste.isEmpty()) {
			return true;
		}
		Iterator<T> firstIterator = liste.iterator();
		
		return true;
	}
}
