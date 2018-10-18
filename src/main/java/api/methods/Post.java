package api.methods;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Клим on 17.10.2018.
 */
public class Post {

    public static void postWithAuth(String url, String token, List<NameValuePair> params) throws IOException {
    HttpClient httpclient = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(url);
    httpPost.addHeader("Authorization", "Bearer " + token); // add the authorization header to the request
    httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

    //Execute and get the response.
    HttpResponse response = httpclient.execute(httpPost);
    String stringResponse = EntityUtils.toString(response.getEntity());
    Assert.assertTrue(stringResponse.contains("id") && stringResponse.contains("name") && stringResponse.contains("type"));

    }
}
