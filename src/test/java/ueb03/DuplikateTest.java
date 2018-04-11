package ueb03;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static ueb03.Duplikate.findeDuplikate;

class DuplikateTest {
	@Test
	void testFindeDuplikate() {
		String t1 = "In Ulm! und um Ulm! und um Ulm herum!";

		Set<String> s1 = findeDuplikate(t1);

		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};

		assertEquals(3, s1.size());  // Ulm und um
		assertTrue(s1.contains("Ulm", c));
		assertTrue(s1.contains("und",c));
		assertTrue(s1.contains("um",c));
		assertFalse(s1.contains("In",c));
		assertFalse(s1.contains("herum",c));
		assertFalse(s1.contains("Ulm!",c));  // keine Satzzeichen!

		String t2 = "Ein armer Affe";
		Set<String> s2 = findeDuplikate(t2);

		assertEquals(0, s2.size());

		String t3 = "Wenn Fliegen hinter Fliegen fliegen?";
		Set<String> s3 = findeDuplikate(t3);

		assertEquals(1, s3.size());
		assertTrue(s3.contains("Fliegen",c));
		assertFalse(s3.contains("fliegen",c));
	}

}