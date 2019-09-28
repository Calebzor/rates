package hu.tvarga.conversion.dto;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertNull;

public class ConversionTest {

	@Test
	public void ConversionNullMap() {
		Conversion conversion = new Conversion("EUR", BigDecimal.ONE, null);

		assertNull(conversion.getRates());
	}
}