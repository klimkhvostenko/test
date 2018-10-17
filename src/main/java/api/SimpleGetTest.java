package api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Клим on 16.10.2018.
 */
public class SimpleGetTest {
    @Test
    public void main() throws IOException {
        String url = "https://api.pdffiller.com/v1/document";
        String token = "3acRIpaqeI06eLB3PGassVyCJgYgOARgHbXID0Bq";
        String responseBody = GetTest.getWithAuth(url,token);
        JSONObject obj = new JSONObject(responseBody);
        JSONArray arr = obj.getJSONArray("items");
        List<String> values = new ArrayList<String>() ;
        for(int i = 0; i < arr.length(); i++){
            String name = arr.getJSONObject(i).getString("name");
            values.add(name);
        }
//        values.toString();
    }
//    private String getFiles(String response){
//       List<String> = response.
//    }
}
