package com.ImageRating.ImageRating;

import com.ImageRating.ImageRating.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class ImageRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageRatingApplication.class, args);
	}

}
