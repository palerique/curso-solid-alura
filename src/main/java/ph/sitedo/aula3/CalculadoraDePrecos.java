package ph.sitedo.aula3;

interface TabelaDePreco {

		double descontoPara(double valor);
}

interface ServicoDeEntrega {

		double para(String cidade);
}

/**
 * Created by PauloHenrique on 01/07/2015.
 */
public class CalculadoraDePrecos {

		private final TabelaDePreco    tabelaDePreco;
		private final ServicoDeEntrega servicoDeEntrega;

		CalculadoraDePrecos(TabelaDePreco tabelaDePreco, ServicoDeEntrega servicoDeEntrega) {

				this.tabelaDePreco = tabelaDePreco;
				this.servicoDeEntrega = servicoDeEntrega;
		}

		public double calcula(Compra produto) {

				double desconto = tabelaDePreco.descontoPara(produto.getValor());
				double frete = servicoDeEntrega.para(produto.getCidade());

				return produto.getValor() * (1 - desconto) + frete;
		}

}

class Compra {

		private double valor;
		private String cidade;

		public double getValor() {

				return valor;
		}

		public void setValor(double valor) {

				this.valor = valor;
		}

		public String getCidade() {

				return cidade;
		}

		public void setCidade(String cidade) {

				this.cidade = cidade;
		}
}

class TabelaDePrecoPadrao implements TabelaDePreco {

		public double descontoPara(double valor) {

				if (valor > 5000)
						return 0.03;
				if (valor > 1000)
						return 0.05;
				return 0;
		}
}

class Frete implements ServicoDeEntrega {

		public double para(String cidade) {

				if ("SAO PAULO".equals(cidade.toUpperCase())) {
						return 15;
				}
				return 30;
		}
}
