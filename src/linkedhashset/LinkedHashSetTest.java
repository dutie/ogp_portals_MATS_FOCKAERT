package linkedhashset;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedHashSetTest {

	@Test
	void test() {
		LinkedHashSet list = new LinkedHashSet();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		Object[] array = list.toArray();
		
		for(int i = 1; i < array.length; i++) {
			assertEquals(i, array[i-1]);	
		}
			
	}

}
