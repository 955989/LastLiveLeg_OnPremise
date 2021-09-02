/**@author ugoudar
 * SpringRest Application
 */
package com;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableScheduling
//@PropertySource("application.properties")

public class SpringrestApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SpringrestApplication.class, args);
    }

    @Configuration
    @EnableAsync
    public class AsyncConfiguration {
        @Bean(name = "asyncExecutor")
        public Executor asyncExecutor() {
            final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(3);
            executor.setMaxPoolSize(3);
            executor.setQueueCapacity(100);
            executor.setThreadNamePrefix("AsynchThread-");
            executor.initialize();
            return executor;
        }
    }

}
