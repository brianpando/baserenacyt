package config;

public interface JsonTransformer {
	
	String toJSON(Object data);
	Object fromJSON(String json, Class clazz);
}
