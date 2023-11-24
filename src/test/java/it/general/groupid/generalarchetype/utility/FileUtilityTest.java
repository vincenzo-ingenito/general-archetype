package it.general.groupid.generalarchetype.utility;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import it.general.groupid.generalarchetype.exception.base.BusinessException;

class FileUtilityTest {

	@Test
	void testGetFileFromInternalResources() {
		String filename = "testFile.txt";
		assertThrows(BusinessException.class, () -> FileUtility.getFileFromInternalResources(filename));
	}

}