/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.errors;

import com.pti.sdk.core.PTIClientApiException;
import java.lang.Object;

public final class NotFoundError extends PTIClientApiException {
  /**
   * The body of the response that triggered the exception.
   */
  private final Object body;

  public NotFoundError(Object body) {
    super("NotFoundError", 404, body);
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
