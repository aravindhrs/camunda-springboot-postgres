package com.bpm.workflow.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;

  private String orderId;

  private String orderType;

  private String orderName;

  private double orderPrice;

}
