package br.com.letscode.config;

import br.com.letscode.repository.PedidoRepository;
import br.com.letscode.service.EmailService;
import br.com.letscode.service.PedidoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public EmailService emailService() {
        return new EmailService("877", "123");
    }

}
