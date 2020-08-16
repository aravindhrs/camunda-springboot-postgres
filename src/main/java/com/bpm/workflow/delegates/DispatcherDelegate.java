package com.bpm.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class DispatcherDelegate implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    execution.getProcessEngineServices().getRuntimeService().correlateMessage("dispatchGoods",
        execution.getProcessBusinessKey(), execution.getVariables());
  }

}
