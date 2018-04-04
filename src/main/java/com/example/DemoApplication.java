package com.example;

import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@MapperScan("com.example.mapper")
public class DemoApplication {
	protected static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		logger.info("SpringBoot Start Success");
	}

	@Bean
	public JettyServerCustomizer jettyServerCustomizer() {
		return server -> {
			// Tweak the connection config used by Jetty to handle incoming HTTP
			// connections
			final QueuedThreadPool threadPool = server.getBean(QueuedThreadPool.class);
			threadPool.setMaxThreads(100);
			threadPool.setMinThreads(20);
		};
	}

	@Profile("jetty")
	@Bean
	public JettyServletWebServerFactory jettyServletWebServerFactoryy(JettyServerCustomizer jettyServerCustomizer) {
		JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
		factory.addServerCustomizers(jettyServerCustomizer);
		return factory;
	}
}
