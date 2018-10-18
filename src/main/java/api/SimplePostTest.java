package api;

import api.methods.PostTest;
import org.junit.Assert;
import org.junit.Test;
import web.GetDOcumentsFromWeb;

import java.io.IOException;

/**
 * Created by Клим on 16.10.2018.
 */
public class SimplePostTest {
    @Test
    public void main() throws IOException {
        String url = "https://api.pdffiller.com/v1/document";
        String token = "VvPROjVXfQJQVe04BPc05DyQe9NpW03F1XhV4UcB";
        PostTest.postWithAuth(url,token);
        GetDOcumentsFromWeb getDOcumentsFromWeb = new GetDOcumentsFromWeb();
        String lastAddedDocumentsNameOnWeb = getDOcumentsFromWeb.getLastAddedDocumentsName();
        Assert.assertTrue(lastAddedDocumentsNameOnWeb.contains("fw9"));
    }

}
