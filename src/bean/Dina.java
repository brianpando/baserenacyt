package bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.persistence.internal.oxm.conversion.Base64;

public class Dina {

	public String obtenerInvestigador() throws IOException {
		String investigador = null;
		String userpass ="usrJMROJAS:usrJMROJAS";
		URL url= new URL("http://190.12.69.77:9098/v1/investigadores/1/42943567");
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		String autenticacion="Basic "+ java.util.Base64.getEncoder().encodeToString(userpass.getBytes());
		con.setRequestProperty("Authorization", autenticacion);
		int status = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		investigador = content.toString();
		return investigador;
	}
	
	
}
