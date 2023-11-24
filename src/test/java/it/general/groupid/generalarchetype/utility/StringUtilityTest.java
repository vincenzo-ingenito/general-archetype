package it.general.groupid.generalarchetype.utility;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.general.groupid.generalarchetype.utility.StringUtility;
import lombok.NoArgsConstructor;

class StringUtilityTest {

    @Test
    @DisplayName("Test isNullOrEmpty with null input")
    void testIsNullOrEmptyWithNull() {
        assertTrue(StringUtility.isNullOrEmpty(null));
    }

    @Test
    @DisplayName("Test isNullOrEmpty with empty input")
    void testIsNullOrEmptyWithEmpty() {
        assertTrue(StringUtility.isNullOrEmpty(""));
    }

    @Test
    @DisplayName("Test isNullOrEmpty with non-empty input")
    void testIsNullOrEmptyWithNonEmpty() {
        assertFalse(StringUtility.isNullOrEmpty("Hello, World!"));
    }

    @Test
    @DisplayName("Test encodeSHA256 with null input")
    void testEncodeSHA256WithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> StringUtility.encodeSHA256(null));
    }

    @Test
    @DisplayName("Test encodeSHA256 with valid input")
    void testEncodeSHA256WithValidInput() {
        byte[] input = "Hello, World!".getBytes();
        assertNotNull(StringUtility.encodeSHA256(input));
    }

    @Test
    @DisplayName("Test encodeSHA256B64 with null input")
    void testEncodeSHA256B64WithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> StringUtility.encodeSHA256B64(null));
    }

    @Test
    @DisplayName("Test encodeSHA256B64 with valid input")
    void testEncodeSHA256B64WithValidInput() {
        String input = "Hello, World!";
        assertNotNull(StringUtility.encodeSHA256B64(input));
    }

    @Test
    @DisplayName("Test encodeSHA256Hex with null input")
    void testEncodeSHA256HexWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> StringUtility.encodeSHA256Hex(null));
    }

    @Test
    @DisplayName("Test encodeSHA256Hex with valid input")
    void testEncodeSHA256HexWithValidInput() {
        String input = "Hello, World!";
        assertNotNull(StringUtility.encodeSHA256Hex(input));
    }

    @Test
    @DisplayName("Test generateUUID")
    void testGenerateUUID() {
        assertNotNull(StringUtility.generateUUID());
    }


    @Test
    @DisplayName("Test toJSONJackson with valid input")
    void testToJSONJacksonWithValidInput() {
        SampleObject sampleObject = new SampleObject("John Doe", 25);
        String json = StringUtility.toJSONJackson(sampleObject);
        assertNotNull(json);
        assertTrue(json.contains("John Doe"));
        assertTrue(json.contains("25"));
    }

    @Test
    @DisplayName("Test fromJSONJackson with valid input")
    void testFromJSONJacksonWithValidInput() {
        String json = "{\"name\":\"Jane Doe\",\"age\":30}";
        SampleObject result = assertDoesNotThrow(() -> StringUtility.fromJSONJackson(json, SampleObject.class));
        assertNotNull(result);
        assertEquals("Jane Doe", result.getName());
        assertEquals(30, result.getAge());
    }

    @NoArgsConstructor
    private static class SampleObject {
        private String name;
        private int age;

        public SampleObject(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}