/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.errors;

import com.pti.sdk.core.PTIClientApiException;
import java.lang.Object;

public final class TooManyRequestsError extends PTIClientApiException {
  /**
   * The body of the response that triggered the exception.
   */
  private final Object body;

  public TooManyRequestsError(Object body) {
    super("TooManyRequestsError", 429, body);
    this.body = body;
  }

  /**
   * @return the body
   */
  @Override
  public Object body() {
    return this.body;
  }
}
