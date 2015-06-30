package ph.sitedo;

import java.util.Calendar;

import static ph.sitedo.Cargo.*;

enum Cargo {
		DESENVOLVEDOR,
		DBA,
		TESTER
}

/**
 * Created by Paulo Henrique on 29/06/2015.
 */
public class CalculadoraDeSalario {

		public double calcula(Funcionario funcionario) {

				if (DESENVOLVEDOR.equals(funcionario.getCargo())) {
						return dezOuVintePorcento(funcionario);
				}

				if (DBA.equals(funcionario.getCargo()) || TESTER.equals(funcionario.getCargo())) {
						return quinzeOuVinteCincoPorcento(funcionario);
				}

				throw new RuntimeException("funcionario invalido");
		}

		private double dezOuVintePorcento(Funcionario funcionario) {

				if (funcionario.getSalarioBase() > 3000.0) {
						return funcionario.getSalarioBase() * 0.8;
				} else {
						return funcionario.getSalarioBase() * 0.9;
				}
		}

		private double quinzeOuVinteCincoPorcento(Funcionario funcionario) {

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

}
