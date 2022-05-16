package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreditCardInfos
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T06:10:14.366Z")


public class CreditCardInfos   {
  @JsonProperty("card_code")
  private String cardCode = null;

  @JsonProperty("expiration_date")
  private String expirationDate = null;

  @JsonProperty("possessor_name")
  private String possessorName = null;

  @JsonProperty("secret_code")
  private String secretCode = null;

  public CreditCardInfos cardCode(String cardCode) {
    this.cardCode = cardCode;
    return this;
  }

  /**
   * Get cardCode
   * @return cardCode
  **/
  @ApiModelProperty(value = "")


  public String getCardCode() {
    return cardCode;
  }

  public void setCardCode(String cardCode) {
    this.cardCode = cardCode;
  }

  public CreditCardInfos expirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  /**
   * Get expirationDate
   * @return expirationDate
  **/
  @ApiModelProperty(value = "")


  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  public CreditCardInfos possessorName(String possessorName) {
    this.possessorName = possessorName;
    return this;
  }

  /**
   * Get possessorName
   * @return possessorName
  **/
  @ApiModelProperty(value = "")


  public String getPossessorName() {
    return possessorName;
  }

  public void setPossessorName(String possessorName) {
    this.possessorName = possessorName;
  }

  public CreditCardInfos secretCode(String secretCode) {
    this.secretCode = secretCode;
    return this;
  }

  /**
   * Get secretCode
   * @return secretCode
  **/
  @ApiModelProperty(value = "")


  public String getSecretCode() {
    return secretCode;
  }

  public void setSecretCode(String secretCode) {
    this.secretCode = secretCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditCardInfos creditCardInfos = (CreditCardInfos) o;
    return Objects.equals(this.cardCode, creditCardInfos.cardCode) &&
        Objects.equals(this.expirationDate, creditCardInfos.expirationDate) &&
        Objects.equals(this.possessorName, creditCardInfos.possessorName) &&
        Objects.equals(this.secretCode, creditCardInfos.secretCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardCode, expirationDate, possessorName, secretCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditCardInfos {\n");
    
    sb.append("    cardCode: ").append(toIndentedString(cardCode)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
    sb.append("    possessorName: ").append(toIndentedString(possessorName)).append("\n");
    sb.append("    secretCode: ").append(toIndentedString(secretCode)).append("\n");
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

