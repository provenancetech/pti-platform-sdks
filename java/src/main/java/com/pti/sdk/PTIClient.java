/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk;

import com.pti.sdk.core.ClientOptions;
import com.pti.sdk.core.Suppliers;
import com.pti.sdk.resources.authorization.AuthorizationClient;
import com.pti.sdk.resources.collectuserdata.CollectUserDataClient;
import com.pti.sdk.resources.estimatetransactioncost.EstimateTransactionCostClient;
import com.pti.sdk.resources.executetransaction.ExecuteTransactionClient;
import com.pti.sdk.resources.marketplace.MarketplaceClient;
import com.pti.sdk.resources.transactionassessment.TransactionAssessmentClient;
import com.pti.sdk.resources.userassessment.UserAssessmentClient;
import com.pti.sdk.resources.wallets.WalletsClient;
import java.util.function.Supplier;

public class PTIClient {
  protected final ClientOptions clientOptions;

  protected final Supplier<AuthorizationClient> authorizationClient;

  protected final Supplier<WalletsClient> walletsClient;

  protected final Supplier<CollectUserDataClient> collectUserDataClient;

  protected final Supplier<TransactionAssessmentClient> transactionAssessmentClient;

  protected final Supplier<UserAssessmentClient> userAssessmentClient;

  protected final Supplier<EstimateTransactionCostClient> estimateTransactionCostClient;

  protected final Supplier<ExecuteTransactionClient> executeTransactionClient;

  protected final Supplier<MarketplaceClient> marketplaceClient;

  public PTIClient(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.authorizationClient = Suppliers.memoize(() -> new AuthorizationClient(clientOptions));
    this.walletsClient = Suppliers.memoize(() -> new WalletsClient(clientOptions));
    this.collectUserDataClient = Suppliers.memoize(() -> new CollectUserDataClient(clientOptions));
    this.transactionAssessmentClient = Suppliers.memoize(() -> new TransactionAssessmentClient(clientOptions));
    this.userAssessmentClient = Suppliers.memoize(() -> new UserAssessmentClient(clientOptions));
    this.estimateTransactionCostClient = Suppliers.memoize(() -> new EstimateTransactionCostClient(clientOptions));
    this.executeTransactionClient = Suppliers.memoize(() -> new ExecuteTransactionClient(clientOptions));
    this.marketplaceClient = Suppliers.memoize(() -> new MarketplaceClient(clientOptions));
  }

  public AuthorizationClient authorization() {
    return this.authorizationClient.get();
  }

  public WalletsClient wallets() {
    return this.walletsClient.get();
  }

  public CollectUserDataClient collectUserData() {
    return this.collectUserDataClient.get();
  }

  public TransactionAssessmentClient transactionAssessment() {
    return this.transactionAssessmentClient.get();
  }

  public UserAssessmentClient userAssessment() {
    return this.userAssessmentClient.get();
  }

  public EstimateTransactionCostClient estimateTransactionCost() {
    return this.estimateTransactionCostClient.get();
  }

  public ExecuteTransactionClient executeTransaction() {
    return this.executeTransactionClient.get();
  }

  public MarketplaceClient marketplace() {
    return this.marketplaceClient.get();
  }

  public static PTIClientBuilder builder() {
    return new PTIClientBuilder();
  }
}
