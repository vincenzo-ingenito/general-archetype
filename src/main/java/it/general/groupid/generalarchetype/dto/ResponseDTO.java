/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package it.general.groupid.generalarchetype.dto;


import javax.validation.constraints.Size;
 
import lombok.Getter;
import lombok.Setter;

/**
 * Base response.
 */
@Getter
@Setter
public class ResponseDTO {

	/**
	 * Trace id log.
	 */
	@Size(min = 0, max = 100)
	private String traceID;

	/**
	 * Span id log.
	 */
	@Size(min = 0, max = 100)
	private String spanID;

	/**
	 * Instantiates a new response DTO.
	 */
	public ResponseDTO() {
	}

	/**
	 * Instantiates a new response DTO.
	 *
	 * @param traceInfo the trace info
	 */
	public ResponseDTO(final LogTraceInfoDTO traceInfo) {
		traceID = traceInfo.getTraceID();
		spanID = traceInfo.getSpanID();
	}

}