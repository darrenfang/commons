package com.darrenfang.commons.exception;

import org.springframework.dao.DuplicateKeyException;

/**
 * 记录重复异常
 */
public class RecordDuplicateException extends DuplicateKeyException {

    /**
     * Constructor for DuplicateKeyException.
     */
    public RecordDuplicateException() {
        super("记录已存在");
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
}
