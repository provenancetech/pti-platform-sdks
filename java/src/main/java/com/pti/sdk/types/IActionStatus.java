/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.types;

import java.lang.String;
import java.util.Optional;

public interface IActionStatus {
  Optional<ResourceType> getResourceType();

  Optional<String> getRequestId();

  Optional<String> getClientId();

  Optional<String> getUserId();

  Optional<String> getDate();
}
