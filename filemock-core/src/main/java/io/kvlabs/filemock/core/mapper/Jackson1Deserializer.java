package io.kvlabs.filemock.core.mapper;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Utility class to un marshal service response to mock using jackson (
 * codehaus)
 *
 * @param <T>
 * @author kanchana-prasanth
 * @since 1.0.0
 */
class Jackson1Deserializer extends AbstractFileDeserializer {

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
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            // to allow coercion of JSON empty String ("") to null Object value:
            mapper.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, false);
            //read
        }
        return mapper.readValue(jsonString, tclass);
    }

}
