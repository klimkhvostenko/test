package api;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Клим on 16.10.2018.
 */
public class SimpleGetTest {
    @Test
    public void main() throws IOException {
        String url = "https://api.pdffiller.com/v1/document";
        String token = "3acRIpaqeI06eLB3PGassVyCJgYgOARgHbXID0Bq";
//        GetTest getTest = new GetTest();
        GetTest.getWithAuth(url,token);

    }
    private String getFiles(String response){
       List<String> = response.
    }
}
