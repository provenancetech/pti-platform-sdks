/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.types;

import java.lang.Integer;
import java.util.Optional;

public interface IManagedError {
  Optional<ErrorType> getType();

  Optional<Integer> getCode();
}
