package ph.sitedo.aula2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PauloHenrique on 29/06/2015.
 */
public class GeradorDeNotaFiscalTest {

		@Test public void deveGerarFatura() throws Exception {

				List<Acao> acoes = new ArrayList<Acao>();

				acoes.add(new EnviadorDeEmail() {

						public void executar(NotaFiscal nf) {

								enviaEmail(nf);
						}

						public void enviaEmail(NotaFiscal nf) {

								System.out.println("enviando e-mail");
						}
				});

				acoes.add(new NotaFiscalDao() {

						public void persiste(NotaFiscal nf) {

								System.out.println("persistindo!!!");
						}

						public void executar(NotaFiscal nf) {

								persiste(nf);

						}
				});

				GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes);

				Fatura fatura = new Fatura();

				gerador.gera(fatura);
		}
}