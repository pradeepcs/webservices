package org.csp.webservice.repository;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component
public class ServiceRepository {


	public String getServiceResponse(String name) {
		return readFile(name, StandardCharsets.UTF_8);
	}
	
	
	
	static String readFile(String path, Charset encoding) {
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(path));
			return new String(encoded, encoding);
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
}
