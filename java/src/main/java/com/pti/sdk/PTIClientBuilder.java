/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk;

import com.pti.sdk.core.ClientOptions;
import com.pti.sdk.core.Environment;
import java.lang.String;

public final class PTIClientBuilder {
  private final ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

  private String ptiClientId = null;

  private Environment environment = Environment.DEFAULT;

  /**
   * Sets ptiClientId
   */
  public PTIClientBuilder ptiClientId(String ptiClientId) {
    this.ptiClientId = ptiClientId;
    return this;
  }

  public PTIClientBuilder environment(Environment environment) {
    this.environment = environment;
    return this;
  }

  public PTIClientBuilder url(String url) {
    this.environment = Environment.custom(url);
    return this;
  }

  public PTIClientBuilder privateKeyPath(String privateKeyPath) {
    this.clientOptionsBuilder.privateKeyPath(privateKeyPath);
    return this;
  }

  public PTIClient build() {
    if (ptiClientId == null) {
      throw new RuntimeException("Please provide clientId");
    }
    this.clientOptionsBuilder.addHeader("x-pti-client-id", this.ptiClientId);
    clientOptionsBuilder.environment(this.environment);
    return new PTIClient(clientOptionsBuilder.build());
  }
}
