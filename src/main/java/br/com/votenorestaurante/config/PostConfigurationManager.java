package br.com.votenorestaurante.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostConfigurationManager {
	@Autowired
	private List<PostConfiguration> configurations;

	public void runAllConfigurations() {
		for (PostConfiguration postConfiguration : configurations) {
			postConfiguration.configure();
		}
	}

}
