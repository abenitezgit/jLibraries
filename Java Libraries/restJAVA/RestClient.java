import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import eContact.ConexionHTTP;

public class RestClient {
	
	static int CONNECTION_TIMEOUT = 8000;
	static int READ_TIMEOUT = 8000;
	static String BASE_URL_1 = "http://10.33.66.30:8090/Service1.svc/rest";
	static String BASE_URL_2 = "http://gesys-demo.e-contact.cl:8080/WS_IVRNodos/services";
	
	public static void main(String args[]){
		RestClient cliente = new RestClient();
		cliente.ejemploGET();
		
		cliente.ejemploPOST();
	}
	
	public void ejemploGET(){
		ConexionHTTP conexion = new ConexionHTTP(CONNECTION_TIMEOUT, READ_TIMEOUT);
		
		String rut = "11111111";
		String clave = "1234";
		String strUrl = BASE_URL_1+"/getAuthenticate/"+rut+"/"+clave;
				
		try {
			System.out.println("****** EJEMPLO GET ******");
			
			JSONObject json = new JSONObject(conexion.performGetCall(strUrl));
			
			System.out.println("**** RESULTADO OBTENIDO: "+json.toString());
			
			JSONObject json2 = json.getJSONObject("getRestAuthenticateResult");
			System.out.println("**** getRestAuthenticateResult: "+json2);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void ejemploPOST(){
		ConexionHTTP conexion = new ConexionHTTP(CONNECTION_TIMEOUT, READ_TIMEOUT);
		
		String strUrl = BASE_URL_2+"/authenticate";
				
		try {
			System.out.println("****** EJEMPLO POST ******");
			
			HashMap<String, Object> postDataParams = new HashMap<String, Object>();		
			postDataParams.put("token", "11111111");
			postDataParams.put("subtoken", "1");
			postDataParams.put("secret", "1234");
			
			JSONObject json = new JSONObject(conexion.performPostCall(strUrl, postDataParams));
			
			System.out.println("**** RESULTADO OBTENIDO: "+json.toString());
						
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
