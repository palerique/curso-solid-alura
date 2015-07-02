package ph.sitedo.aula3;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by PauloHenrique on 01/07/2015.
 */
public class CalculadoraDePrecosTest {

		@Test public void deveCalcular() throws Exception {

				Compra compra = new Compra();

				compra.setValor(1000.0);
				compra.setCidade("Brasília");

				double calculado = new CalculadoraDePrecos(new TabelaDePrecoPadrao(), new Frete()).calcula(compra);

				Assert.assertEquals("deve ser igual", 1030.0, calculado, 000000001);
		}
}