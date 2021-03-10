package com.deutschebank.tradestore.exception;

import com.deutschebank.tradestore.constants.Constants;

public class InvalidTradeException extends RuntimeException {

    private final String id;

    public InvalidTradeException(final String id) {
        super(Constants.INVALID_TRADE + id);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
