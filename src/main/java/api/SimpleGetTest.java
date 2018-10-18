package api;

import api.methods.GetTest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import web.GetDOcumentsFromWeb;

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
        String token = "VvPROjVXfQJQVe04BPc05DyQe9NpW03F1XhV4UcB";
        String responseBody = GetTest.getWithAuth(url,token);
        JSONObject obj = new JSONObject(responseBody);
        JSONArray arr = obj.getJSONArray("items");
        List<String> apiListOfNames = new ArrayList<String>() ;
        for(int i = 0; i < arr.length(); i++){
            String name = arr.getJSONObject(i).getString("name").replaceAll(".pdf","");
            apiListOfNames.add(name);
        }

        GetDOcumentsFromWeb getDOcumentsFromWeb = new GetDOcumentsFromWeb();
        List<String> webListOfNames = getDOcumentsFromWeb.getListOfDocuments();
        Assert.assertTrue(webListOfNames.equals(apiListOfNames));
    }

    @After
    public void tearDown() throws Exception {


    }
}
