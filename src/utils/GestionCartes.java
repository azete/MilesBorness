package utils;

import java.util.ArrayList;
import java.util.Collections;
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
		int index = random.nextInt(liste.size());
		ListIterator<T> iterator = liste.listIterator(index);
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
		for (int j = 0; j < liste.size(); j++) {
			if (!result.contains(liste.get(j))) {
				for (int i = 0; i < Collections.frequency(liste, liste.get(j)); i++)
					result.add(liste.get(j));
			}
		}
		return result;
	}

	public static <T> boolean verifierRassemblement(List<T> liste) {
		if (liste.isEmpty()) {
			return true;
		}
		for (ListIterator<T> it1 = liste.listIterator(); it1.hasNext();) {
			T lastValue = it1.next();
			T currentValue = it1.next();
			int currentIndice = it1.nextIndex();
			if (!lastValue.equals(currentValue) && rechercheElem(liste, lastValue, currentIndice)) {
					return false;
				}
				lastValue = currentValue;
			}
		return true;
	}

	public static <T> boolean rechercheElem(List<T> liste, T lastValue, int currentIndice) {
		for (ListIterator<T> it2 = liste.listIterator(currentIndice); it2.hasNext();) {
			if (it2.next().equals(lastValue)) {
				return true;
			}
		}
		return false;
	}
}
