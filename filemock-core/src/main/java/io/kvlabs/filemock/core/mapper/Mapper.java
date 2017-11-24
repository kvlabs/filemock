package io.kvlabs.filemock.core.mapper;

/**
 * Supported JSON mapper
 *
 * @author kanchana-prasanth
 * @since 1.0.0
 */
public enum Mapper {
    JACKSON_1,
    JACKSON_2,
    MOSHI,
    GSON;

    public static final Mapper DEFAULT = JACKSON_1;
}
