package UnitTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import co.com.ceiba.oc.dominio.model.ApprovalOrder;


public class PurchaseOrderTest {
	
	@Test
	public void testCuandoSumaDosNumerosEntoncesRetornaResultado() {
		
		//Arrage
		int n1 = 5;
		int n2 = 7;
		int suma = 12;
		
		ApprovalOrder aproval = new ApprovalOrder();

		//Act
		int result = aproval.sumaDigitos(n1, n2);
		
		//Assert
		assertEquals(suma, result);
		
		
		
	}

}
