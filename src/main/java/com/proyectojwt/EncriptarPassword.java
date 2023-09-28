package com.proyectojwt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		var password = "123";
		System.out.println("password " + password);
		System.out.println("password encriptado " + encriptarpass(password));

	}

	public static String encriptarpass(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		return encoder.encode(password);
	}

}
