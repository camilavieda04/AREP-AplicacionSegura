package arep;
import static spark.Spark.*;

public class SecureServer {
    public static void main(String[] args) {
        port(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath ,truststorePassword);
        secure("keys/tallerkeystore.p12", "arep1234", null, null);
        get("/hello", (req, res) -> "Hello World");
    }

	static int getPort() {
        if (System.getenv("PORT") != null) {
           	return Integer.parseInt(System.getenv("PORT"));
        }
        return 5678;
    }


}
