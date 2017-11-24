package io.kvlabs.filemock.core.exception;

/**
 * {@code JsonMappingException} is the superclass of those RuntimeException that
 * can be thrown if the file json string for mocking is not deserializable .
 *
 * @author kanchana-prasanth
 * @since 1.0
 */
public class JsonMappingException extends RuntimeException {

    /**
     * Constructs a given given json failed to deserialize with the specified
     * detail message and cause.
     * <p>
     *
     * @param message the detail message (which is saved for later retrieval by
     * the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     * {@link #getCause()} method). (A <tt>null</tt> value is permitted, and
     * indicates that the cause is nonexistent or unknown.)
     * @since 1.0
     */
    public JsonMappingException(String message, Throwable cause) {
        super(message, cause);
    }
}
