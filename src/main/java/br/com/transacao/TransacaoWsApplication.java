package br.com.transacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "br.com.transacao.*")
public class TransacaoWsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TransacaoWsApplication.class, args);
		
	}
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TransacaoWsApplication.class);
	}

}
