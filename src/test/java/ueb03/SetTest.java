package ueb03;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {
	@Test
	void testStringSet() {

		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};

		Set<String> impl = new SetImpl<String>();
		String str = "In Ulm und um Ulm und um Ulm herum";

		for (String s : str.split(" ")) {
			impl.add(s, c);
		}

		System.out.println(impl);

		// sollte sein: In Ulm und um herum
		assertEquals(5, impl.size());

		// Elemente testen
		assertTrue(impl.contains("In",c));
		assertTrue(impl.contains("Ulm",c));
		assertFalse(impl.contains("",c));
		assertFalse(impl.contains("Hans",c));

		// zwei herausnehmen
		impl.remove("Ulm",c);
		impl.remove("um",c);
		assertThrows(NoSuchElementException.class, () -> impl.remove("Hams",c));

		assertEquals(3, impl.size());

		System.out.println(impl);

		// nochmal Elemente testen
		assertFalse(impl.contains("Ulm",c));
		assertFalse(impl.contains("um",c));
		assertFalse(impl.contains("Hans",c));
	}

}