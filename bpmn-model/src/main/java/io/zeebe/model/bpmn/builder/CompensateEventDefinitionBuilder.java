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
package io.zeebe.model.bpmn.builder;

import io.zeebe.model.bpmn.BpmnModelInstance;
import io.zeebe.model.bpmn.instance.CompensateEventDefinition;

public class CompensateEventDefinitionBuilder
    extends AbstractCompensateEventDefinitionBuilder<CompensateEventDefinitionBuilder> {

  public CompensateEventDefinitionBuilder(
      BpmnModelInstance modelInstance, CompensateEventDefinition element) {
    super(modelInstance, element, CompensateEventDefinitionBuilder.class);
  }
}
