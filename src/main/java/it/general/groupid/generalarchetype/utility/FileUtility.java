/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package it.general.groupid.generalarchetype.utility;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import it.general.groupid.generalarchetype.exception.base.BusinessException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class FileUtils.
 *
 * Utility to manager file.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileUtility {

	/**
	 * Max size chunk.
	 */
	private static final int CHUNK_SIZE = 16384;


	/**
	 * Metodo per il recupero del contenuto di un file dalla folder interna "/src/main/resources".
	 *
	 * @param filename	nome del file
	 * @return			contenuto del file
	 */
	public static byte[] getFileFromInternalResources(final String filename) {
		if (filename == null || filename.trim().isEmpty()) {
			throw new IllegalArgumentException("Filename cannot be null or an empty string");
		}

		byte[] b = null;
		try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)) {
			b = getByteFromInputStream(is);
		} catch (Exception e) {
			log.error("FILE UTILS getFileFromInternalResources(): Errore in fase di recupero del contenuto di un file dalla folder '/src/main/resources'. ", e);
			throw new BusinessException(e);
		}
		return b;
	}


	/**
	 * Recupero contenuto file da input stream.
	 *
	 * @param is
	 *            input stream
	 * @return contenuto file
	 */
	private static byte[] getByteFromInputStream(final InputStream is) {
		byte[] b;

		if (is == null) {
			log.error("Input stream is null");
			throw new IllegalArgumentException("Input stream is null");
		}

		try {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int nRead;
			byte[] data = new byte[CHUNK_SIZE];

			while ((nRead = is.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}
			buffer.flush();
			b = buffer.toByteArray();
		} catch (Exception e) {
			log.error("Errore durante il trasform da InputStream a byte[]: ", e);
			throw new BusinessException(e);
		}
		return b;
	}

}
