package com.gt.demo.notification.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateNotificationParam
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-13T11:16:24.299378300+08:00[Asia/Shanghai]")


public class CreateNotificationParam   {
  @JsonProperty("dtlNum")
  private String dtlNum = null;

  @JsonProperty("custCode")
  private String custCode = null;

  @JsonProperty("custName")
  private String custName = null;

  @JsonProperty("status")
  private String status = null;

  public CreateNotificationParam dtlNum(String dtlNum) {
    this.dtlNum = dtlNum;
    return this;
  }

  /**
   * Get dtlNum
   * @return dtlNum
   **/
  @Schema(description = "")
  
    public String getDtlNum() {
    return dtlNum;
  }

  public void setDtlNum(String dtlNum) {
    this.dtlNum = dtlNum;
  }

  public CreateNotificationParam custCode(String custCode) {
    this.custCode = custCode;
    return this;
  }

  /**
   * Get custCode
   * @return custCode
   **/
  @Schema(description = "")
  
    public String getCustCode() {
    return custCode;
  }

  public void setCustCode(String custCode) {
    this.custCode = custCode;
  }

  public CreateNotificationParam custName(String custName) {
    this.custName = custName;
    return this;
  }

  /**
   * Get custName
   * @return custName
   **/
  @Schema(description = "")
  
    public String getCustName() {
    return custName;
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }

  public CreateNotificationParam status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @Schema(description = "")
  
    public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateNotificationParam createNotificationParam = (CreateNotificationParam) o;
    return Objects.equals(this.dtlNum, createNotificationParam.dtlNum) &&
        Objects.equals(this.custCode, createNotificationParam.custCode) &&
        Objects.equals(this.custName, createNotificationParam.custName) &&
        Objects.equals(this.status, createNotificationParam.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dtlNum, custCode, custName, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateNotificationParam {\n");
    
    sb.append("    dtlNum: ").append(toIndentedString(dtlNum)).append("\n");
    sb.append("    custCode: ").append(toIndentedString(custCode)).append("\n");
    sb.append("    custName: ").append(toIndentedString(custName)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
