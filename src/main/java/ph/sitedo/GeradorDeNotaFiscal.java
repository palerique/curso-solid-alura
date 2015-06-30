package ph.sitedo;

import java.util.List;

interface Acao {

		void executar(NotaFiscal nf);
}

interface EnviadorDeEmail extends Acao {

		void enviaEmail(NotaFiscal nf);
}

interface NotaFiscalDao extends Acao {

		void persiste(NotaFiscal nf);
}

/**
 * Created by PauloHenrique on 29/06/2015.
 */

public class GeradorDeNotaFiscal {

		List<Acao> acoes;

		public GeradorDeNotaFiscal(List<Acao> acoes) {

				this.acoes = acoes;
		}

		public NotaFiscal gera(Fatura fatura) {

				double valor = fatura.getValorMensal();

				NotaFiscal nf = new NotaFiscal(valor, impostoSimplesSobreO(valor));

				for (Acao a : acoes) {
						a.executar(nf);
				}

				return nf;
		}

		private double impostoSimplesSobreO(double valor) {

				return valor * 0.06;
		}

}

class Fatura {

		private double valorMensal;
		private String cliente;

		public Fatura() {

		}

		public Fatura(double valorMensal, String cliente) {

				this.valorMensal = valorMensal;
				this.cliente = cliente;
		}

		public double getValorMensal() {

				return valorMensal;
		}

		public void setValorMensal(double valorMensal) {

				this.valorMensal = valorMensal;
		}

		public String getCliente() {

				return cliente;
		}

		public void setCliente(String cliente) {

				this.cliente = cliente;
		}

}

class NotaFiscal {

		private int    id;
		private double valorBruto;
		private double impostos;

		public NotaFiscal(int id, double valorBruto, double impostos) {

				this.id = id;
				this.valorBruto = valorBruto;
				this.impostos = impostos;
		}

		public NotaFiscal(double valorBruto, double impostos) {

				this(0, valorBruto, impostos);
		}

		public int getId() {

				return id;
		}

		public void setId(int id) {

				this.id = id;
		}

		public double getValorBruto() {

				return valorBruto;
		}

		public void setValorBruto(double valorBruto) {

				this.valorBruto = valorBruto;
		}

		public double getImpostos() {

				return impostos;
		}

		public void setImpostos(double impostos) {

				this.impostos = impostos;
		}

		public double getValorLiquido() {

				return this.valorBruto - this.impostos;
		}

}
