package space.akshaymathur.examples.jerseymemleak.boot;

import com.google.inject.AbstractModule;
import space.akshaymathur.examples.jerseymemleak.resources.EchoResource;
import space.akshaymathur.examples.jerseymemleak.resources.ProxyResource;
import space.akshaymathur.examples.jerseymemleak.utils.WebClient;

import javax.ws.rs.client.Client;

/**
 * @author : akshay.mathur
 * @since : 14-11-2019
 **/
public class GuiceModule extends AbstractModule {

    private final Client client;

    public GuiceModule(Client client) {
        this.client = client;
    }

    @Override
    protected void configure() {
        bind(Client.class).toInstance(client);
        bind(WebClient.class);
        bind(EchoResource.class);
        bind(ProxyResource.class);
    }
}
