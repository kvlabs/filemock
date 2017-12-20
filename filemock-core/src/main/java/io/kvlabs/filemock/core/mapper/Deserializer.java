package io.kvlabs.filemock.core.mapper;

/**
 * Supported Deserializer operations
 *
 * @author kanchana-prasanth
 * @since 1.0.0
 */
public interface Deserializer {

    /**
     * Un marshal json file to Object
     *
     * @param <T> as type of output
     * @param path as the patch to json resource
     * @param tclass as the response class
     * @return un-marshaled value of json
     * @since 1.0.0
     */
    <T> T deserialize(String path, Class<T> tclass);

    /**
     * Un marshal json file to Object
     *
     * @param <T> as type of output
     * @param path as the patch to json resource
     * @param tclass as the response class
     * @param safeParse true of on safe mode
     * @return un-marshaled value of json
     * @since 1.0.0
     */
    <T> T deserialize(String path, Class<T> tclass, boolean safeParse);
}
