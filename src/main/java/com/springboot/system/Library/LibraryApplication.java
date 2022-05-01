package com.springboot.system.Library;

import com.springboot.system.Library.utilities.DBConnection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	private static ConfigurableApplicationContext ctx;
	public static void main(String[] args) {
		ctx = SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DBConnection.connectToDb();
		if( !DBConnection.getYesNo() ){
			ctx.close();
		}
	}
}
