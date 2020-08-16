package com.bpm.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.stereotype.Component;

import com.bpm.workflow.dto.Order;

@Component
public class ObjectSerializeDelegate implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    Order order = Order.builder().orderId("OR3487").orderName("Laptop").orderPrice(80000.00).orderType("Electronics")
        .build();
    ObjectValue orderTypedObjectValue = Variables.objectValue(order)
        .serializationDataFormat(Variables.SerializationDataFormats.JAVA).create();
    execution.setVariable("orderDataJava", orderTypedObjectValue);
  }

}
