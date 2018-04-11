package ueb03;

import java.util.Comparator;

interface Set<T> {
	/**
	 * Fügt das übergebene Element in das Set ein.
	 * @param s
	 * @return true, wenn `s` neu eingefügt wurde, false wenn es bereits enthalten war
	 */
	boolean add(T s, Comparator<T> comp);

	/**
	 * Prüft, ob ein Element im Set enthalten ist.
	 */
	boolean contains(T s, Comparator<T> comp);

	/**
	 * Entfernt ein Element aus dem Set; wirft eine NoSuchElementException
	 * wenn das Element nicht enthalten war.
	 *
	 * @return Das entfernte Element
	 * @throws java.util.NoSuchElementException Wenn das Element nicht vorhanden war.
	 */
	T remove(T s, Comparator<T> comp);

	/**
	 * Gibt die Größe des Sets zurück
	 */
	int size();
}
