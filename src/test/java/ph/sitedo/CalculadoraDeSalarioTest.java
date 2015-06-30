package ph.sitedo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Paulo Henrique on 29/06/2015.
 */
public class CalculadoraDeSalarioTest {

		@Test public void deveCalcularSalarioDeDBA() throws Exception {

				Funcionario fun = new Funcionario();
				fun.setCargo(Cargo.DBA);
				fun.setSalarioBase(1000.0);

				double valor = new CalculadoraDeSalario().calcula(fun);

				Assert.assertEquals("", 850, valor, 0.000000001);

		}

		@Test public void deveCalcularSalarioDeTester() throws Exception {

				Funcionario fun = new Funcionario();
				fun.setCargo(Cargo.TESTER);
				fun.setSalarioBase(1000.0);

				double valor = new CalculadoraDeSalario().calcula(fun);

				Assert.assertEquals("", 850, valor, 0.000000001);

		}

		@Test public void deveCalcularSalarioDeDev() throws Exception {

				Funcionario fun = new Funcionario();
				fun.setCargo(Cargo.DESENVOLVEDOR);
				fun.setSalarioBase(1000.0);

				double valor = new CalculadoraDeSalario().calcula(fun);

				Assert.assertEquals("", 900, valor, 0.000000001);

		}

		@Test public void deveCalcularSalarioDeDBA3000() throws Exception {

				Funcionario fun = new Funcionario();
				fun.setCargo(Cargo.DBA);
				fun.setSalarioBase(3000.0);

				double valor = new CalculadoraDeSalario().calcula(fun);

				Assert.assertEquals("", 2250, valor, 0.000000001);

		}

		@Test public void deveCalcularSalarioDeTester3000() throws Exception {

				Funcionario fun = new Funcionario();
				fun.setCargo(Cargo.TESTER);
				fun.setSalarioBase(3000.0);

				double valor = new CalculadoraDeSalario().calcula(fun);

				Assert.assertEquals("", 2250, valor, 0.000000001);

		}

		@Test public void deveCalcularSalarioDeDev3000() throws Exception {

				Funcionario fun = new Funcionario();
				fun.setCargo(Cargo.DESENVOLVEDOR);
				fun.setSalarioBase(3000.0);

				double valor = new CalculadoraDeSalario().calcula(fun);

				Assert.assertEquals("", 2700, valor, 0.000000001);

		}
}