/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package it.general.groupid.generalarchetype.exception.base;

import it.general.groupid.generalarchetype.dto.ErrorDTO;
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