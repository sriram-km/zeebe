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
import io.zeebe.model.bpmn.instance.Task;

/** @author Sebastian Menski */
public abstract class AbstractTaskBuilder<B extends AbstractTaskBuilder<B, E>, E extends Task>
    extends AbstractActivityBuilder<B, E> {

  protected AbstractTaskBuilder(BpmnModelInstance modelInstance, E element, Class<?> selfType) {
    super(modelInstance, element, selfType);
  }

  /** camunda extensions */

  /**
   * @deprecated use camundaAsyncBefore() instead.
   *     <p>Sets the camunda async attribute to true.
   * @return the builder object
   */
  @Deprecated
  public B camundaAsync() {
    element.setCamundaAsyncBefore(true);
    return myself;
  }

  /**
   * @deprecated use camundaAsyncBefore(isCamundaAsyncBefore) instead.
   *     <p>Sets the camunda async attribute.
   * @param isCamundaAsync the async state of the task
   * @return the builder object
   */
  @Deprecated
  public B camundaAsync(boolean isCamundaAsync) {
    element.setCamundaAsyncBefore(isCamundaAsync);
    return myself;
  }
}
