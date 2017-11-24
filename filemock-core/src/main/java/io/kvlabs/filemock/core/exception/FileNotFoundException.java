package io.kvlabs.filemock.core.exception;

/**
 * {@code FileNotFoundException} is the superclass of those runtimeException
 * that can be thrown if the file given for mocking is not accessible .
 *
 * @author kanchana-prasanth
 * @since 1.0
 */
public class FileNotFoundException extends RuntimeException {

    /**
     * Constructs a new file not found exception with the specified detail
     * message and cause.
     * <p>
     *
     * @param message the detail message (which is saved for later retrieval by
     * the {@link #getMessage()} method).
     * @since 1.0
     */
    public FileNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new file not found exception with the specified detail
     * message and cause.
     * <p>
     *
     * @param message the detail message (which is saved for later retrieval by
     * the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     * {@link #getCause()} method). (A <tt>null</tt> value is permitted, and
     * indicates that the cause is nonexistent or unknown.)
     * @since 1.0
     */
    public FileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
