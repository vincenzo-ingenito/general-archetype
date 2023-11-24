/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package it.general.groupid.generalarchetype.dto;
 
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema; 
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class ErrorResponseDTO.
 *
 * 
 * 	Error response.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ErrorResponseDTO extends ResponseDTO {

	@Schema(description = "Identificativo del problema verificatosi")
	@Size(min = 0, max = 100)
	private String type;
	
	@Schema(description = "Sintesi del problema (invariante per occorrenze diverse dello stesso problema)")
	@Size(min = 0, max = 1000)
	private String title;

	@Schema(description = "Descrizione del problema")
	@Size(min = 0, max = 1000)
	private String detail;
 
	@Schema(description = "URI che potrebbe fornire ulteriori informazioni riguardo l'occorrenza del problema")
	@Size(min = 0, max = 100)
	private String instance;
 
	public ErrorResponseDTO(final LogTraceInfoDTO traceInfo, final ErrorDTO inError) {
		super(traceInfo);
		type = inError.getType();
		title = inError.getTitle();
		detail = inError.getDetail();
		instance = inError.getInstance();
	}

}