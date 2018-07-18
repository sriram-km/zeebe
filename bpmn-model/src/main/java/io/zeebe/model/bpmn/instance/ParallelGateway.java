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

import io.zeebe.model.bpmn.builder.ParallelGatewayBuilder;

/**
 * The BPMN parallelGateway element
 *
 * @author Sebastian Menski
 */
public interface ParallelGateway extends Gateway {

  /** camunda extensions */

  /** @deprecated use isCamundaAsyncBefore() instead. */
  @Deprecated
  boolean isCamundaAsync();

  /** @deprecated use setCamundaAsyncBefore(isCamundaAsyncBefore) instead. */
  @Deprecated
  void setCamundaAsync(boolean isCamundaAsync);

  @Override
  ParallelGatewayBuilder builder();
}
