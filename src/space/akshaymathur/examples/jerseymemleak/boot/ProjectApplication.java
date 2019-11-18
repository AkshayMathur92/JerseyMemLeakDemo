package space.akshaymathur.examples.jerseymemleak.boot;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.message.GZipEncoder;
import space.akshaymathur.examples.jerseymemleak.resources.EchoResource;
import space.akshaymathur.examples.jerseymemleak.resources.ProxyResource;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * @author : akshay.mathur
 * @since : 14-11-2019
 **/
public class ProjectApplication extends Application<ProjectConfiguration> {

    private Injector injector;

    public static void main(String[] args) throws Exception {
        new ProjectApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ProjectConfiguration> bootstrap) {
        Client client = ClientBuilder.newClient();
//        client.register(GZipEncoder.class);
        injector= Guice.createInjector(new GuiceModule(client));
    }

    public void run(ProjectConfiguration projectConfiguration, Environment environment) {
        environment.jersey().register(injector.getInstance(ProxyResource.class));
        environment.jersey().register(injector.getInstance(EchoResource.class));
    }
}