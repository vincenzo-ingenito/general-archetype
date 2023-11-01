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
package it.finanze.sanita.fse.generalarchetype.utility;

import static it.finanze.sanita.fse.generalarchetype.config.Constants.App.SHA_ALGORITHM;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.binary.Hex;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import it.finanze.sanita.fse.generalarchetype.exception.BusinessException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringUtility {

	private static final String ERROR_MSG = "Errore in fase di calcolo sha";

	/**
	 * Returns {@code true} if the String passed as parameter is null or empty.
	 * 
	 * @param str	String to validate.
	 * @return		{@code true} if the String passed as parameter is null or empty.
	 */
	public static boolean isNullOrEmpty(final String str) {
		return str == null || str.isEmpty();
	}

	/**
	 * Returns the encoded String of the SHA-256 algorithm represented in base 64.
	 * 
	 * @param objectToEncode String to encode.
	 * @return String Encoded.
	 */
	public static String encodeSHA256(final byte[] objectToEncode) {
		try {
			final MessageDigest digest = MessageDigest.getInstance(SHA_ALGORITHM);
			return Hex.encodeHexString(digest.digest(objectToEncode));
		} catch (final Exception e) {
			log.error(ERROR_MSG, e);
			throw new BusinessException(ERROR_MSG, e);
		}
	}

	/**
	 * Returns the encoded String of the SHA-256 algorithm represented in base 64.
	 * 
	 * @param objectToEncode String to encode.
	 * @return String Encoded.
	 */
	public static String encodeSHA256B64(final String objectToEncode) {
		try {
			final MessageDigest digest = MessageDigest.getInstance(SHA_ALGORITHM);
			final byte[] hash = digest.digest(objectToEncode.getBytes());
			return encodeBase64(hash);
		} catch (final Exception e) {
			log.error(ERROR_MSG, e);
			throw new BusinessException(ERROR_MSG, e);
		}
	}

	/**
	 * Returns the encoded String of the SHA-256 algorithm encoded represented in base hex.
	 * 
	 * @param objectToEncode String to encode.
	 * @return String Encoded.
	 */
	public static String encodeSHA256Hex(final String objectToEncode) {
		try {
			final MessageDigest digest = MessageDigest.getInstance(SHA_ALGORITHM);
			final byte[] hash = digest.digest(objectToEncode.getBytes());
			return encodeHex(hash);
		} catch (final Exception e) {
			log.error(ERROR_MSG, e);
			throw new BusinessException(ERROR_MSG, e);
		}
	}

	/**
	 * Encode in Base64 the byte array passed as parameter.
	 * 
	 * @param input	The byte array to encode.
	 * @return		The encoded byte array to String.
	 */
	public static String encodeBase64(final byte[] input) {
		return Base64.getEncoder().encodeToString(input);
	}

	/**
	 * Encodes the byte array passed as parameter in hexadecimal.
	 * 
	 * @param input	The byte array to encode.
	 * @return		The encoded byte array to String.
	 */
	public static String encodeHex(final byte[] input) {
		return Hex.encodeHexString(input);
	}

	public static String generateUUID() {
		return UUID.randomUUID().toString();
	}


	/**
	 * Transformation from Object to Json.
	 * 
	 * @param obj	object to transform
	 * @return		json
	 */
	public static String toJSONJackson(final Object obj) {
		String out = "";
		try {
			final ObjectMapper objectMapper = new ObjectMapper(); 
			objectMapper.registerModule(new JavaTimeModule());
			objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
			objectMapper.setTimeZone(TimeZone.getDefault());
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			out = objectMapper.writeValueAsString(obj);
		} catch(final Exception ex) {
			log.error("Error while running to json jackson");
			throw new BusinessException(ex);
		}
		return out; 
	}

	public static <T> T fromJSONJackson(final String json, final Class<T> clazz) throws JsonMappingException, JsonProcessingException {
		final ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, clazz);
	}
}
