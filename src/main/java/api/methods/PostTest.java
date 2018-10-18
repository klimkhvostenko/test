package api.methods;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Клим on 17.10.2018.
 */
public class PostTest {

    public static void postWithAuth(String url, String token) throws IOException {
    HttpClient httpclient = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(url);
    httpPost.addHeader("Authorization", "Bearer " + token); // add the authorization header to the request

    // Request parameters and other properties.
    List<NameValuePair> params = new ArrayList<NameValuePair>(3);
    params.add(new BasicNameValuePair("file", "https://www.irs.gov/pub/irs-pdf/fw9.pdf"));
    params.add(new BasicNameValuePair("name", "fw9.pdf"));
    params.add(new BasicNameValuePair("folder_id", "0"));
    httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

    //Execute and get the response.
    HttpResponse response = httpclient.execute(httpPost);
    String stringResponse = EntityUtils.toString(response.getEntity());
    Assert.assertTrue(stringResponse.contains("id") && stringResponse.contains("name") && stringResponse.contains("type"));

    }
}
