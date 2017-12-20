package com.darrenfang.commons.exception;

/**
 * 记录重复异常
 */
public class RecordDuplicateException extends BusinessException {

    /**
     * Constructor for DuplicateKeyException.
     */
    public RecordDuplicateException() {
        super("记录已存在。");
    }

    /**
     * Constructor for DuplicateKeyException.
     *
     * @param msg the detail message
     */
    public RecordDuplicateException(String msg) {
        super(msg);
    }

    /**
     * Constructor for DuplicateKeyException.
     *
     * @param msg   the detail message
     * @param cause the root cause from the data access API in use
     */
    public RecordDuplicateException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Constructs a new runtime exception with the specified cause and a
     * detail message of <tt>(cause==null ? null : cause.toString())</tt>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).  This constructor is useful for runtime exceptions
     * that are little more than wrappers for other throwables.
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A <tt>null</tt> value is
     *              permitted, and indicates that the cause is nonexistent or
     *              unknown.)
     * @since 1.4
     */
    public RecordDuplicateException(Throwable cause) {
        super("记录已存在。", cause);
    }
}
