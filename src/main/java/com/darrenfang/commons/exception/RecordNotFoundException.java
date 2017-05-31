package com.darrenfang.commons.exception;

import org.springframework.dao.IncorrectResultSizeDataAccessException;

/**
 * 记录不存在异常
 */
public class RecordNotFoundException extends IncorrectResultSizeDataAccessException {
    /**
     * Constructor for IncorrectResultSizeDataAccessException.
     */
    public RecordNotFoundException() {
        super(1);
    }

    /**
     * Constructor for IncorrectResultSizeDataAccessException.
     *
     * @param msg the detail message
     */
    public RecordNotFoundException(String msg) {
        super(msg, 1);
    }

    /**
     * Constructor for IncorrectResultSizeDataAccessException.
     *
     * @param msg the detail message
     * @param ex  the wrapped exception
     */
    public RecordNotFoundException(String msg, Throwable ex) {
        super(msg, 1, ex);
    }

    /**
     * Constructor for IncorrectResultSizeDataAccessException.
     *
     * @param expectedSize the expected result size
     */
    public RecordNotFoundException(int expectedSize) {
        super(expectedSize);
    }

    /**
     * Constructor for IncorrectResultSizeDataAccessException.
     *
     * @param expectedSize the expected result size
     * @param actualSize   the actual result size (or -1 if unknown)
     */
    public RecordNotFoundException(int expectedSize, int actualSize) {
        super(expectedSize, actualSize);
    }

    /**
     * Constructor for IncorrectResultSizeDataAccessException.
     *
     * @param msg          the detail message
     * @param expectedSize the expected result size
     */
    public RecordNotFoundException(String msg, int expectedSize) {
        super(msg, expectedSize);
    }

    /**
     * Constructor for IncorrectResultSizeDataAccessException.
     *
     * @param msg          the detail message
     * @param expectedSize the expected result size
     * @param ex           the wrapped exception
     */
    public RecordNotFoundException(String msg, int expectedSize, Throwable ex) {
        super(msg, expectedSize, ex);
    }

    /**
     * Constructor for IncorrectResultSizeDataAccessException.
     *
     * @param msg          the detail message
     * @param expectedSize the expected result size
     * @param actualSize   the actual result size (or -1 if unknown)
     */
    public RecordNotFoundException(String msg, int expectedSize, int actualSize) {
        super(msg, expectedSize, actualSize);
    }

    /**
     * Constructor for IncorrectResultSizeDataAccessException.
     *
     * @param msg          the detail message
     * @param expectedSize the expected result size
     * @param actualSize   the actual result size (or -1 if unknown)
     * @param ex           the wrapped exception
     */
    public RecordNotFoundException(String msg, int expectedSize, int actualSize, Throwable ex) {
        super(msg, expectedSize, actualSize, ex);
    }
}
