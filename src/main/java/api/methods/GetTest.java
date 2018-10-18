package api.methods;

/**
 * Created by Клим on 17.10.2018.
 */
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

public class GetTest {

    public static String getWithAuth(String url, String token) throws IOException {

            HttpClient httpclient = HttpClientBuilder.create().build();  // the http-client, that will send the request
            HttpGet httpGet = new HttpGet(url);   // the http GET request
            httpGet.addHeader("Authorization", "Bearer " + token); // add the authorization header to the request
            HttpResponse response = httpclient.execute(httpGet); // the client executes the request and gets a response
            int responseCode = response.getStatusLine().getStatusCode();  // check the response code
            Assert.assertTrue(responseCode == 200);

                    String stringResponse = EntityUtils.toString(response.getEntity());  // now you have the response as String, which you can convert to a JSONObject or do other stuff
                    System.out.print(stringResponse);
                    return stringResponse;
    }

}
