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

package io.zeebe.model.bpmn.impl.instance.camunda;

import static io.zeebe.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_EXPRESSION;
import static io.zeebe.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;

import io.zeebe.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import io.zeebe.model.bpmn.instance.camunda.CamundaExpression;
import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN expression camunda extension element
 *
 * @author Sebastian Menski
 */
public class CamundaExpressionImpl extends BpmnModelElementInstanceImpl
    implements CamundaExpression {

  public static void registerType(ModelBuilder modelBuilder) {
    final ModelElementTypeBuilder typeBuilder =
        modelBuilder
            .defineType(CamundaExpression.class, CAMUNDA_ELEMENT_EXPRESSION)
            .namespaceUri(CAMUNDA_NS)
            .instanceProvider(
                new ModelTypeInstanceProvider<CamundaExpression>() {
                  @Override
                  public CamundaExpression newInstance(ModelTypeInstanceContext instanceContext) {
                    return new CamundaExpressionImpl(instanceContext);
                  }
                });

    typeBuilder.build();
  }

  public CamundaExpressionImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }
}
