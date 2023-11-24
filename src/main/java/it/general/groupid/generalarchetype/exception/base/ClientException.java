/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package it.general.groupid.generalarchetype.exception.base;
 
import it.general.groupid.generalarchetype.dto.ErrorResponseDTO;
import lombok.Getter;

@Getter
public class ClientException extends RuntimeException {

    /**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 2940592148957767936L;

	private final ErrorResponseDTO error;
	
	private final Integer statusCode;
	
	/**
	 * Exception constructor.
	 * 
	 * @param e Exception to be shown.
	 */
	public ClientException(final ErrorResponseDTO error, final Integer statusCode) {
		this.error = error;
		this.statusCode = statusCode;
	}

}