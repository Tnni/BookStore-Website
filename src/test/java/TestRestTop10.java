import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class TestRestTop10 {
	public static void main(String[] argv){
		//create a client
		Client client = ClientBuilder.newClient();
		//create a web target
		WebTarget wt=client.target("http://127.0.0.1:8181/rest/report/top10"); 
		//create a request and invoke get; the argument of get is the type of return
		String xml = wt.request(MediaType.TEXT_XML) .get(String.class);
		System.out.println(xml);
	}
}