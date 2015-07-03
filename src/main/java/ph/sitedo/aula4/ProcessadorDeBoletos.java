package ph.sitedo.aula4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum MeioDePagamento {

		BOLETO,
		CARTAO
}

/**
 * Created by PauloHenrique on 02/07/2015.
 */
public class ProcessadorDeBoletos {

		public void processa(List<Boleto> boletos, Fatura fatura) {

				fatura.adicionarPagamentos(boletos);
		}
}

class Boleto {

		private final double valor;

		public Boleto(double valor) {

				this.valor = valor;
		}

		public double getValor() {

				return valor;
		}

}

class Fatura {

		private final String          cliente;
		private final double          valor;
		private final List<Pagamento> pagamentos;
		private       boolean         pago;

		public Fatura(String cliente, double valor) {

				this.cliente = cliente;
				this.valor = valor;
				this.pagamentos = new ArrayList<Pagamento>();
				this.pago = false;
		}

		public String getCliente() {

				return cliente;
		}

		private double getValor() {

				return valor;
		}

		public List<Pagamento> getPagamentos() {

				return Collections.unmodifiableList(pagamentos);
		}

		public boolean isPago() {

				double total = 0;
				for (Pagamento pagamento : pagamentos) {
						total += pagamento.getValor();
				}

				return total > getValor();
		}

		public void setPago(boolean pago) {

				this.pago = pago;
		}

		private void adicionarPagamento(Boleto boleto) {

				Pagamento pagamento = new Pagamento(boleto.getValor());
				this.pagamentos.add(pagamento);
		}

		public void adicionarPagamentos(List<Boleto> boletos) {

				for (Boleto boleto : boletos) {
						adicionarPagamento(boleto);
				}

		}
}

class Pagamento {

		private final double          valor;
		private final MeioDePagamento forma;

		public Pagamento(double valor) {

				this.valor = valor;
				this.forma = MeioDePagamento.BOLETO;
		}

		public double getValor() {

				return valor;
		}

		public MeioDePagamento getForma() {

				return forma;
		}

		@Override public boolean equals(Object obj) {

				if (!(obj instanceof Pagamento)) {
						return false;
				}
				Pagamento outro = (Pagamento) obj;

				return !(forma != outro.forma || Double.doubleToLongBits(valor) != Double.doubleToLongBits(outro.valor));

		}

}
