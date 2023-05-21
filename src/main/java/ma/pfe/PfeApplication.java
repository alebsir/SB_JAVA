package ma.pfe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class PfeApplication {

    private final static Logger LOGGER= LoggerFactory.getLogger(PfeApplication.class);

    private Environment env;
    public PfeApplication(Environment env) {
        this.env = env;
    }




    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(PfeApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOGGER.info("Access URLs:\n----------------------------------------------------------\n\t" +
                        "Local: \t\thttp://127.0.0.1:{}/swagger-ui/#/\n\t" +
                        "External: \thttp://{}:{}/swagger-ui/#/\n----------------------------------------------------------",

                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port")

        );
//        System.out.println("hello world");
    }
}
