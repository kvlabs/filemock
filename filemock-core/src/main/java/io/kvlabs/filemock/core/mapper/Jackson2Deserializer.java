package io.kvlabs.filemock.core.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class to un marshal service response to mock using jackson (
 * fasterxml)
 *
 * @param <T>
 * @author kanchana-prasanth
 * @link https://github.com/FasterXML/jackson-databind/wiki/Serialization-features
 * @link https://github.com/FasterXML/jackson-databind#commonly-used-features
 * @since 1.0.0
 */
class Jackson2Deserializer extends AbstractFileDeserializer {

    /**
     * Convert String to instance of given class
     *
     * @param <T>
     * @param safeParse true if safe parse is enabled
     * @param jsonString as json string
     * @param tclass as class to be transformed into
     * @return instance of given class
     * @throws Exception
     * @since 1.0.0
     */
    @Override
    protected <T> T fromString(boolean safeParse, String jsonString, Class<T> tclass) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        if (safeParse) {
            //marking response safe
            // to prevent exception when encountering unknown property:
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            // to allow coercion of JSON empty String ("") to null Object value:
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            //read
        }
        return mapper.readValue(jsonString, tclass);
    }
}
