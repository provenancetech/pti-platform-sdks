/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.core;

import java.lang.Exception;
import java.lang.RuntimeException;
import java.lang.String;

/**
 * This class serves as the base exception for all errors in the SDK.
 */
public class PTIClientException extends RuntimeException {
  public PTIClientException(String message) {
    super(message);
  }

  public PTIClientException(String message, Exception e) {
    super(message, e);
  }
}
