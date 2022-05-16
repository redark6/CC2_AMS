package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.CreditCardInfos;
import io.swagger.model.PaymentOrder;
import io.swagger.model.UserInfos;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Payment
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T06:10:14.366Z")


public class Payment   {
  @JsonProperty("buyer_info")
  private UserInfos buyerInfo = null;

  @JsonProperty("checkout_id")
  private String checkoutId = null;

  @JsonProperty("credit_card_info")
  private CreditCardInfos creditCardInfo = null;

  @JsonProperty("payment_orders")
  @Valid
  private List<PaymentOrder> paymentOrders = null;

  public Payment buyerInfo(UserInfos buyerInfo) {
    this.buyerInfo = buyerInfo;
    return this;
  }

  /**
   * Get buyerInfo
   * @return buyerInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UserInfos getBuyerInfo() {
    return buyerInfo;
  }

  public void setBuyerInfo(UserInfos buyerInfo) {
    this.buyerInfo = buyerInfo;
  }

  public Payment checkoutId(String checkoutId) {
    this.checkoutId = checkoutId;
    return this;
  }

  /**
   * Get checkoutId
   * @return checkoutId
  **/
  @ApiModelProperty(value = "")


  public String getCheckoutId() {
    return checkoutId;
  }

  public void setCheckoutId(String checkoutId) {
    this.checkoutId = checkoutId;
  }

  public Payment creditCardInfo(CreditCardInfos creditCardInfo) {
    this.creditCardInfo = creditCardInfo;
    return this;
  }

  /**
   * Get creditCardInfo
   * @return creditCardInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CreditCardInfos getCreditCardInfo() {
    return creditCardInfo;
  }

  public void setCreditCardInfo(CreditCardInfos creditCardInfo) {
    this.creditCardInfo = creditCardInfo;
  }

  public Payment paymentOrders(List<PaymentOrder> paymentOrders) {
    this.paymentOrders = paymentOrders;
    return this;
  }

  public Payment addPaymentOrdersItem(PaymentOrder paymentOrdersItem) {
    if (this.paymentOrders == null) {
      this.paymentOrders = new ArrayList<PaymentOrder>();
    }
    this.paymentOrders.add(paymentOrdersItem);
    return this;
  }

  /**
   * Get paymentOrders
   * @return paymentOrders
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PaymentOrder> getPaymentOrders() {
    return paymentOrders;
  }

  public void setPaymentOrders(List<PaymentOrder> paymentOrders) {
    this.paymentOrders = paymentOrders;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payment payment = (Payment) o;
    return Objects.equals(this.buyerInfo, payment.buyerInfo) &&
        Objects.equals(this.checkoutId, payment.checkoutId) &&
        Objects.equals(this.creditCardInfo, payment.creditCardInfo) &&
        Objects.equals(this.paymentOrders, payment.paymentOrders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buyerInfo, checkoutId, creditCardInfo, paymentOrders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment {\n");
    
    sb.append("    buyerInfo: ").append(toIndentedString(buyerInfo)).append("\n");
    sb.append("    checkoutId: ").append(toIndentedString(checkoutId)).append("\n");
    sb.append("    creditCardInfo: ").append(toIndentedString(creditCardInfo)).append("\n");
    sb.append("    paymentOrders: ").append(toIndentedString(paymentOrders)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

