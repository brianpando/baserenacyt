package config;

import java.io.IOException;


//Descarga estas 2 librerias y ponlas en tu proyecto, descargar de la pagina
//https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
import com.fasterxml.jackson.core.JsonProcessingException;
//https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTransformerImplJackson implements JsonTransformer {
	
	
	public String toJSON(Object data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
 
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
 
    public Object fromJSON(String json, Class clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
 
            return objectMapper.readValue(json, clazz);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

	
}
