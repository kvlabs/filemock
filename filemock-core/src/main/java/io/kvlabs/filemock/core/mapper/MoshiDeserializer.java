package io.kvlabs.filemock.core.mapper;

import com.squareup.moshi.Moshi;

/**
 * Utility class to un marshal service response to mock using gson
 *
 * @param <T>
 * @author kanchana-prasanth
 * @since 1.0.0
 */
class MoshiDeserializer extends AbstractFileDeserializer {

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
        Moshi moshi = new Moshi.Builder().build();
        return moshi.adapter(tclass).fromJson(jsonString);
    }
}
