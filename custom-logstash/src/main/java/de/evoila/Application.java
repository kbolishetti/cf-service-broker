/**
 * 
 */
package de.evoila;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

import de.evoila.cf.cpi.custom.props.DomainBasedCustomPropertyHandler;
import de.evoila.cf.cpi.custom.props.LogstashCustomPropertyHandler;

/**
 * 
 * @author Johannes Hiemer.
 *
 */
@SpringBootApplication
public class Application {

	@Bean(name = "customProperties")
	public Map<String, String> customProperties() {
		Map<String, String> customProperties = new HashMap<String, String>();
		customProperties.put("es_host", "172.24.102.2:9200");
		customProperties.put("ls_port", "5000");
		return customProperties;
	}

	@Bean
	public DomainBasedCustomPropertyHandler domainPropertyHandler() {
		return new LogstashCustomPropertyHandler();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		Assert.notNull(ctx);
	}

}