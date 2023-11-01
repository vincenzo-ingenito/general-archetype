/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 * 
 * Copyright (C) 2023 Ministero della Salute
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package it.finanze.sanita.fse.generalarchetype.config;

/**
 * Constants application.
 */
public final class Constants {
 
	public static final class Collections {

		private Collections() {

		}
	}
	
	public static final class Headers {

		private Headers() {
			//This method is intentionally left blank.
		}

	}
 
	public static final class Profile {

		public static final String TEST = "test";
		
		public static final String DEV = "dev";
		
		public static final String DOCKER = "docker";

		public static final String TEST_PREFIX = "test_";

		/** 
		 * Constructor.
		 */
		private Profile() {
			//This method is intentionally left blank.
		}

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
  
	/**
	 *	Constants.
	 */
	private Constants() {

	}

}
