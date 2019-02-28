package com.springboot.demo.config;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		// Use the builder to build the health status details that should be reported.
        // If you throw an exception, the status will be DOWN with the exception message.
        
        builder.up()
                .withDetail("app", "Alive and Kicking")
                .withDetail("error", "Nothing! I'm good.");
        builder.withDetail("total", "000000");
        
      /*  
		builder.withDetail("total", this.path.getTotalSpace())
		.withDetail("free", diskFreeInBytes)
		.withDetail("threshold", this.threshold.toBytes());*/
        
	}

}
