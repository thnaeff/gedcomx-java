/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.conclusion;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.ExtensibleData;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.records.HasFieldValueSources;
import org.gedcomx.rt.GedcomxModelVisitor;
import org.gedcomx.rt.RDFRange;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;


/**
 * A reference to genealogical place.
 */
@XmlType ( name = "PlaceReference" )
public class PlaceReference extends ExtensibleData implements HasFieldValueSources {

  private String original;
  private URI descriptionRef;
  private List<ResourceReference> fieldValueSources;

  /**
   * The original value as supplied by the user.
   *
   * @return The original value as supplied by the user.
   */
  public String getOriginal() {
    return original;
  }

  /**
   * The original value as supplied by the user.
   *
   * @param original The original value as supplied by the user.
   */
  public void setOriginal(String original) {
    this.original = original;
  }

  /**
   * A reference to a description of the place being referenced.
   *
   * @return A reference to a description of the place being referenced.
   */
  @XmlAttribute ( name = "description" )
  @JsonName ( "description" )
  @JsonProperty ( "description" )
  @RDFRange (PlaceDescription.class)
  public URI getDescriptionRef() {
    return descriptionRef;
  }

  /**
   * A reference to a description of the place being referenced.
   *
   * @param descriptionRef A reference to a description of the place being referenced.
   */
  @JsonProperty ( "description" )
  public void setDescriptionRef(URI descriptionRef) {
    this.descriptionRef = descriptionRef;
  }

  /**
   * The list of field values that are being used to support this data.
   *
   * @return The list of field values that are being used to support this data.
   */
  @Override
  @XmlElement (name = "sourceFieldValue")
  @JsonProperty ("sourceFieldValues")
  @JsonName ("sourceFieldValues")
  public List<ResourceReference> getFieldValueSources() {
    return fieldValueSources;
  }

  /**
   * The list of field values that are being used to support this data.
   *
   * @param supportingFieldValues The list of field values that are being used to support this data.
   */
  @Override
  @JsonProperty ("sourceFieldValues")
  public void setFieldValueSources(List<ResourceReference> supportingFieldValues) {
    this.fieldValueSources = supportingFieldValues;
  }

  public String toString() {
    return "PlaceReference{" + "original='" + original + "', " + "descriptionRef='" + descriptionRef + '\'' + '}';
  }

  /**
   * Accept a visitor.
   *
   * @param visitor The visitor.
   */
  public void accept(GedcomxModelVisitor visitor) {
    visitor.visitPlaceReference(this);
  }
}
