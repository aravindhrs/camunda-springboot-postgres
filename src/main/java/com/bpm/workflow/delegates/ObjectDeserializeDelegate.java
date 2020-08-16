package com.bpm.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.stereotype.Component;

import com.bpm.workflow.dto.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ObjectDeserializeDelegate implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    ObjectValue typedObjectOrderValue = execution.getVariableTyped("orderDataJava");
    log.info("Type name:{}, SerializationDataFormat:{}", typedObjectOrderValue.getObjectTypeName(),
        typedObjectOrderValue.getSerializationDataFormat());
    Order deserializedOrder = (Order) typedObjectOrderValue.getValue();
    log.info("deserializedOrder:{}", deserializedOrder);
  }

}
