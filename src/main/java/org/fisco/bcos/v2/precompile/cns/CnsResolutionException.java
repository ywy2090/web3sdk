package org.fisco.bcos.v2.precompile.cns;

/** ENS resolution exception. */
public class CnsResolutionException extends RuntimeException {
    public CnsResolutionException(String message) {
        super(message);
    }

    public CnsResolutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
