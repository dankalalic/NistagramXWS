package xws.media;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class MediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaApplication.class, args);
		String demo = System.getProperty("user.home");
		demo = demo + File.separator + "images" + File.separator;
		System.out.println(demo);
	}

}
