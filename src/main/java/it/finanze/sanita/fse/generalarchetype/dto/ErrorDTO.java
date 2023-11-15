/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package it.finanze.sanita.fse.generalarchetype.dto;

import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    
    @Schema(description = "Identificativo della classe del problema verificatosi")
	@Size(min = 0, max = 100)
	private String type;
	
	@Schema(description = "Descrizione della classe del problema verificatosi (invariante per occorrenze diverse dello stesso problema)")
	@Size(min = 0, max = 100)
	private String title;

	@Schema(description = "Descrizione del problema")
	@Size(min = 0, max = 1000)
	private String detail;

	@Schema(description = "URI che identifica la specifica occorrenza del problema")
	@Size(min = 0, max = 100)
	private String instance;
}