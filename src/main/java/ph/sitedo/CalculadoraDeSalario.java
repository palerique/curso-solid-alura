package ph.sitedo;

import java.util.Calendar;

enum Cargo {
		DESENVOLVEDOR(new DezOuVintePorCento()),
		DBA(new QuinzeOuVintePorCento()),
		TESTER(new QuinzeOuVintePorCento());

		private RegraDeCalculo regra;

		Cargo(RegraDeCalculo regra) {

				this.regra = regra;
		}

		public RegraDeCalculo getRegra() {

				return regra;
		}

}

interface RegraDeCalculo {

		double calcula(Funcionario funcionario);
}

/**
 * Created by PauloHenrique on 29/06/2015.
 */
public class CalculadoraDeSalario {

		public double calcula(Funcionario funcionario) {

				return funcionario.calculaSalario();
		}
}

class DezOuVintePorCento implements RegraDeCalculo {

		public double calcula(Funcionario funcionario) {

				if (funcionario.getSalarioBase() > 3000.0) {
						return funcionario.getSalarioBase() * 0.8;
				} else {
						return funcionario.getSalarioBase() * 0.9;
				}
		}
}

class QuinzeOuVintePorCento implements RegraDeCalculo {

		public double calcula(Funcionario funcionario) {

				if (funcionario.getSalarioBase() > 2000.0) {
						return funcionario.getSalarioBase() * 0.75;
				} else {
						return funcionario.getSalarioBase() * 0.85;
				}
		}
}

class Funcionario {

		private int      id;
		private String   nome;
		private Cargo    cargo;
		private Calendar dataDeAdmissao;
		private double   salarioBase;

		public int getId() {

				return id;
		}

		public void setId(int id) {

				this.id = id;
		}

		public String getNome() {

				return nome;
		}

		public void setNome(String nome) {

				this.nome = nome;
		}

		public Cargo getCargo() {

				return cargo;
		}

		public void setCargo(Cargo cargo) {

				this.cargo = cargo;
		}

		public Calendar getDataDeAdmissao() {

				return dataDeAdmissao;
		}

		public void setDataDeAdmissao(Calendar dataDeAdmissao) {

				this.dataDeAdmissao = dataDeAdmissao;
		}

		public double getSalarioBase() {

				return salarioBase;
		}

		public void setSalarioBase(double salarioBase) {

				this.salarioBase = salarioBase;
		}

		public double calculaSalario() {

				return this.getCargo().getRegra().calcula(this);
		}
}
