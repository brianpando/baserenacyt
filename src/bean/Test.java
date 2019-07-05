package bean;

import java.io.IOException;
import java.util.Map;

public class Test {

	public static void main(String[] args) throws IOException {
		
		Dina dina=new Dina();
		String investigador=dina.obtenerInvestigador();
		System.out.println(investigador);
	}

}
