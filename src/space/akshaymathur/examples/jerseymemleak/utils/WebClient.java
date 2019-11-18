package space.akshaymathur.examples.jerseymemleak.utils;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.glassfish.jersey.message.GZipEncoder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author : akshay.mathur
 * @since : 14-11-2019
 **/


@Singleton
public class WebClient {
    private final Client client;

    @Inject
    public WebClient(Client client) {
        this.client = client;
    }

    public Object call(String url){
        WebTarget target = client.target(url);
        target.register(GZipEncoder.class);
        Invocation.Builder invocationBuilder = target.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.get();
        return response.getEntity();
    }
}
