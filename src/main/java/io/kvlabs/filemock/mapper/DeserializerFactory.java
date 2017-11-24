package io.kvlabs.filemock.mapper;

/**
 * Factory class to create Deserializer instance
 *
 * @author kanchana-prasanth
 */
public final class DeserializerFactory {

    /**
     * Create Deserializer instance for the given Mapper type
     *
     * @param mapper
     * @return
     */
    public static Deserializer create(Mapper mapper) {
        Deserializer deserializer = null;
        switch (mapper) {
            case JACKSON_1:
                deserializer = new Jackson1Deserializer();
                break;
            case JACKSON_2:
                deserializer = new Jackson2Deserializer();
                break;
            case GSON:
                deserializer = new GsonDeserializer();
                break;
            case MOSHI:
                deserializer = new MoshiDeserializer();
                break;
            default:
                throw new UnsupportedOperationException("Deserializer not yet avilable for the given type");
        }
        return deserializer;
    }
}
