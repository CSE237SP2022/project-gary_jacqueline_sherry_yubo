package borrower;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BorrowerClassTest {

	@Test
	void ConstructorAndAccessTest() {
		String name = "A";
		int id = 0;
		Borrower person1 = new Borrower(id, name);
		assertEquals(id, person1.getId());
		assertEquals(name, person1.getName());
	}

}
