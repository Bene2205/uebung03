package ueb03;

import java.util.Comparator;

class Duplikate {
	/**
	 * Gibt ein Set mit den Wörtern zurück, welche mindestens zwei mal im Text vorkommen.
	 * Alle Satzzeichen im Text sollen ignoriert werden.
	 * @param text Eingabetext, kann Satzzeichen enthalten welche ignoriert werden.
	 * @return Set mit den Wörtern, welche mind. zwei mal vorkommen.
	 */
	static Set findeDuplikate(String text) {
		// nur Zeichen und Leerzeichen zulassen
		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {
			if (Character.isAlphabetic(c) || c == ' ')
				sb.append(c);
		}
		text = sb.toString();

		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};

		Set<String> s1 = new SetImpl<String>();
		Set<String> s2 = new SetImpl<String>();


		for (String w : text.split(" ")) {
			// kennt das erste Set das Wort bereits, so tritt es zum 2. mal auf!
			if (s1.contains(w, c))
				s2.add(w,c);

			// jedes Wort in das erste Set einfuegen
			s1.add(w,c);
		}

		return s2;
	}
}
