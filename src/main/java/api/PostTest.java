package api;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Клим on 17.10.2018.
 */
public class PostTest {

    public static String postWithAuth(String url, String token) throws IOException {
    HttpClient httpclient = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost("http://www.a-domain.com/foo/");

    // Request parameters and other properties.
    List<NameValuePair> params = new ArrayList<NameValuePair>(2);
    params.add(new BasicNameValuePair("param-1", "12345"));
    params.add(new BasicNameValuePair("param-2", "Hello!"));
    httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

    //Execute and get the response.
    HttpResponse response = httpclient.execute(httpPost);
    HttpEntity entity = response.getEntity();

    if (entity != null) {
        try (InputStream instream = entity.getContent()) {
            // do something useful
        }
    }
        return url;
    }
}
