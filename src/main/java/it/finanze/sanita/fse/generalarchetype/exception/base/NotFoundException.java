/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package it.finanze.sanita.fse.generalarchetype.exception.base;

import it.finanze.sanita.fse.generalarchetype.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotFoundException extends RuntimeException {

    /**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = -3887493213838475769L;
	
	private final transient ErrorDTO error;
}