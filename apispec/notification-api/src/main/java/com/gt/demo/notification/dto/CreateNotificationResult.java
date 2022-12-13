package com.gt.demo.notification.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateNotificationResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-13T11:16:24.299378300+08:00[Asia/Shanghai]")


public class CreateNotificationResult   {
  @JsonProperty("received")
  private Boolean received = null;

  public CreateNotificationResult received(Boolean received) {
    this.received = received;
    return this;
  }

  /**
   * Get received
   * @return received
   **/
  @Schema(description = "")
  
    public Boolean isReceived() {
    return received;
  }

  public void setReceived(Boolean received) {
    this.received = received;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateNotificationResult createNotificationResult = (CreateNotificationResult) o;
    return Objects.equals(this.received, createNotificationResult.received);
  }

  @Override
  public int hashCode() {
    return Objects.hash(received);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateNotificationResult {\n");
    
    sb.append("    received: ").append(toIndentedString(received)).append("\n");
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
