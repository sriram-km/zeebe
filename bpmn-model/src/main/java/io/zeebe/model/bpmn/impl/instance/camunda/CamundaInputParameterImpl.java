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

import static io.zeebe.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_NAME;
import static io.zeebe.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_INPUT_PARAMETER;
import static io.zeebe.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;

import io.zeebe.model.bpmn.instance.camunda.CamundaInputParameter;
import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.camunda.bpm.model.xml.type.attribute.Attribute;

/**
 * The BPMN inputParameter camunda extension element
 *
 * @author Sebastian Menski
 */
public class CamundaInputParameterImpl extends CamundaGenericValueElementImpl
    implements CamundaInputParameter {

  protected static Attribute<String> camundaNameAttribute;

  public static void registerType(ModelBuilder modelBuilder) {
    final ModelElementTypeBuilder typeBuilder =
        modelBuilder
            .defineType(CamundaInputParameter.class, CAMUNDA_ELEMENT_INPUT_PARAMETER)
            .namespaceUri(CAMUNDA_NS)
            .instanceProvider(
                new ModelTypeInstanceProvider<CamundaInputParameter>() {
                  @Override
                  public CamundaInputParameter newInstance(
                      ModelTypeInstanceContext instanceContext) {
                    return new CamundaInputParameterImpl(instanceContext);
                  }
                });

    camundaNameAttribute =
        typeBuilder
            .stringAttribute(CAMUNDA_ATTRIBUTE_NAME)
            .namespace(CAMUNDA_NS)
            .required()
            .build();

    typeBuilder.build();
  }

  public CamundaInputParameterImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  @Override
  public String getCamundaName() {
    return camundaNameAttribute.getValue(this);
  }

  @Override
  public void setCamundaName(String camundaName) {
    camundaNameAttribute.setValue(this, camundaName);
  }
}
