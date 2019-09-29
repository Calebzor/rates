package hu.tvarga.conversion.dto;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class ConversionTest {

	@Test
	public void ConversionNullMap() {
		Conversion conversion = new Conversion(null);

		assertNull(conversion.getRates());
	}
}