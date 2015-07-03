package ph.sitedo.aula4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by PauloHenrique on 02/07/2015.
 */
public class ProcessadorDeBoletosTest {

		@Test public void deveCalcularFatura() {

				ProcessadorDeBoletos processador = new ProcessadorDeBoletos();

				List<Boleto> boletos = new ArrayList<Boleto>();

				Boleto boleto = new Boleto(1000.0);

				boletos.add(boleto);

				Fatura fatura = new Fatura("Astolfo", 5000.0);

				processador.processa(boletos, fatura);

				assertFalse("Deve estar em aberto", fatura.isPago());
				assertEquals("Só deve ter um único pagamento", 1, fatura.getPagamentos().size());
		}

}