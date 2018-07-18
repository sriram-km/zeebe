/*
 * Copyright © 2017 camunda services GmbH (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.zeebe.model.bpmn.instance;

import static io.zeebe.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;
import static org.assertj.core.api.Assertions.assertThat;

import io.zeebe.model.bpmn.BpmnTestConstants;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;

/** @author Sebastian Menski */
public class ServiceTaskTest extends BpmnModelElementInstanceTest {

  @Override
  public TypeAssumption getTypeAssumption() {
    return new TypeAssumption(Task.class, false);
  }

  @Override
  public Collection<ChildElementAssumption> getChildElementAssumptions() {
    return null;
  }

  @Override
  public Collection<AttributeAssumption> getAttributesAssumptions() {
    return Arrays.asList(
        new AttributeAssumption("implementation", false, false, "##WebService"),
        new AttributeAssumption("operationRef"),
        /** camunda extensions */
        new AttributeAssumption(CAMUNDA_NS, "class"),
        new AttributeAssumption(CAMUNDA_NS, "delegateExpression"),
        new AttributeAssumption(CAMUNDA_NS, "expression"),
        new AttributeAssumption(CAMUNDA_NS, "resultVariable"),
        new AttributeAssumption(CAMUNDA_NS, "topic"),
        new AttributeAssumption(CAMUNDA_NS, "type"),
        new AttributeAssumption(CAMUNDA_NS, "taskPriority"));
  }

  @Test
  public void testCamundaTaskPriority() {
    // given
    final ServiceTask service = modelInstance.newInstance(ServiceTask.class);
    assertThat(service.getCamundaTaskPriority()).isNull();
    // when
    service.setCamundaTaskPriority(BpmnTestConstants.TEST_PROCESS_TASK_PRIORITY);
    // then
    assertThat(service.getCamundaTaskPriority())
        .isEqualTo(BpmnTestConstants.TEST_PROCESS_TASK_PRIORITY);
  }
}
