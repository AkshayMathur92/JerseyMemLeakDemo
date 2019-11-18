package space.akshaymathur.examples.jerseymemleak.boot;


import io.dropwizard.Configuration;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author : akshay.mathur
 * @since  : 14-11-2019
 **/
@Data
public class ProjectConfiguration extends Configuration {

    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";
}
