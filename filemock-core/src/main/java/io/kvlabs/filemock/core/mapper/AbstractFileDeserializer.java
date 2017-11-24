package io.kvlabs.filemock.core.mapper;

import io.kvlabs.filemock.core.exception.FileNotFoundException;
import io.kvlabs.filemock.core.exception.JsonMappingException;
import java.io.InputStream;
import java.io.StringWriter;
import org.apache.commons.io.IOUtils;

/**
 * Abstract implementation of Deserializer wraps all IO operations
 *
 * @author kanchana
 * @since 1.0.0
 */
abstract class AbstractFileDeserializer implements Deserializer {

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
    protected abstract <T> T fromString(boolean safeParse, String jsonString, Class<T> tclass) throws Exception;

    /**
     * Un marshal json file to Object
     *
     * @param <T>
     * @param path as the patch to json resource
     * @param tclass as the response class
     * @return un-marshaled value of json
     * @since 1.0.0
     */
    @Override
    public <T> T deserialize(String path, Class<T> tclass) {
        return this.deserialize(path, tclass, true);
    }

    /**
     * Un marshal json file to Object
     *
     * @param <T>
     * @param path as the patch to json resource
     * @param tclass as the response class
     * @param safeParse
     * @return un-marshaled value of json
     * @since 1.0.0
     */
    @Override
    public <T> T deserialize(String path, Class<T> tclass, boolean safeParse) {
        InputStream input = this.getClass().getResourceAsStream(path);
        if (input == null) {
            throw new FileNotFoundException("unable to find the given file [" + path + "]");
        }
        //got file
        try (final StringWriter writter = new StringWriter()) {
            IOUtils.copy(input, writter);
            String jsonAsAString = writter.toString();
            return fromString(safeParse, jsonAsAString, tclass);
        } catch (Exception e) {
            throw new JsonMappingException("unable to parse file", e);
        }
    }
}
