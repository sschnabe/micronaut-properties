package io.micronaut.issue;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Value;
import io.micronaut.runtime.Micronaut;

@Context
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		Micronaut.run(Application.class);
	}

	@PostConstruct
	void init(@Value("${my-stuff.my-property:default-value}") String property) {
		log.info("Value: {}", property);
	}
}