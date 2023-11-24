/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package it.general.groupid.generalarchetype.client;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import com.google.gson.Gson;

import it.general.groupid.generalarchetype.dto.ErrorResponseDTO;
import it.general.groupid.generalarchetype.exception.base.ClientException;
 

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
		return (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR || 
				httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse httpResponse) throws IOException {
		String result = IOUtils.toString(httpResponse.getBody(), StandardCharsets.UTF_8);
		ErrorResponseDTO error = new Gson().fromJson(result, ErrorResponseDTO.class);
		Integer statusCode = httpResponse.getStatusCode().value();
		throw new ClientException(error,statusCode);
	}

}