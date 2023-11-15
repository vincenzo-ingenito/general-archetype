/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package it.finanze.sanita.fse.generalarchetype.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Constants application.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {
 
	public static final class Collections {

		private Collections() {

		}
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE) 
	public static final class Headers {
 

	}
 
	@NoArgsConstructor(access = AccessLevel.PRIVATE)  
	public static final class Profile {

		public static final String TEST = "test";
		
		public static final String DEV = "dev";
		
		public static final String DOCKER = "docker";
  
	 
	}

	public static final class App {
		
		public static final String SHA_ALGORITHM = "SHA-256";
		
		
		private App() {
			//This method is intentionally left blank.
		}
	}
	

	public static final class Client {

		private Client() {}
		
	}
  
	 

}
