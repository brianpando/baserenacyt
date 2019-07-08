package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import config.JsonTransformer;
import config.JsonTransformerImplJackson;


@Controller
public class SubjectController {

	//ejemplo de ruta http://localhost/subfamilies/list via GET
	@RequestMapping(value="/subfamilies/list",method=RequestMethod.GET,consumes = "application/json",produces = "application/json; charset=ISO-8859-1")
	 public void list(HttpServletRequest request, HttpServletResponse httpServletResponse,@RequestBody String jsonIn) throws Exception {
		Map response=new HashMap();	
		List<Map> list = new ArrayList<>();
		try {
			JsonTransformer jsonTransformer= new JsonTransformerImplJackson();	
			// CODIGO PARA IR A LA BD Y CONSULTAR LUEGO LLENAR EN LIST.
			response.put("lista", list);
			httpServletResponse.setCharacterEncoding("UTF-8");
			
			// PARA DEVOLVER UN JSON
			httpServletResponse.getWriter().println( jsonTransformer.toJSON(response) );
		} catch (Exception e) {
			httpServletResponse.setStatus(httpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	 }
	//ejemplo de ruta http://localhost/subfamilies/save via POST
	@RequestMapping(value="/subfamily/save",method=RequestMethod.POST,consumes = "application/json",produces = "application/json; charset=ISO-8859-1")
	 public void save(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonIn) {
		Map response=new HashMap();	 
		try {
			//para recibir parametros por JSON
			JsonTransformer jsonTransformer= new JsonTransformerImplJackson();
			Map map=(Map) jsonTransformer.fromJSON(jsonIn, Map.class );			
			map.put("nombre", map.get("nombre").toString() ); 
			map.put("estado", map.get("estado").toString() ); 
			
			// CODIGO PARA IR A LA BD Y GUARDAR O ELIMINAR
			 response.put("estado", "guardado correcto");
			 httpServletResponse.setCharacterEncoding("UTF-8");
			 httpServletResponse.getWriter().println( response.toString() );
		} catch (Exception e) {
			httpServletResponse.setStatus(httpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
		}
	 }
	
	
	
}
