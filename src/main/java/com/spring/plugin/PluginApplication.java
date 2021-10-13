package com.spring.plugin;

import com.spring.plugin.strategy.WriterPlugin;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.config.EnablePluginRegistries;

@SpringBootApplication
@EnablePluginRegistries(WriterPlugin.class)
public class PluginApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluginApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(PluginRegistry<WriterPlugin,String> plugins) {
		return args -> {
			for(var format: "csv,txt".split(","))
				plugins.getPluginFor(format).get().write("Hello! Spring Plugin!");
		};
	}

}
