/*
 * Copyright 2000-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.intellij.plugins.hcl.terraform.config.model

// Actual model
public open class Property(val type: PropertyType, val value: Any?)
public open class Block(val type: BlockType, vararg val properties: PropertyOrBlock = arrayOf())
public class PropertyOrBlock(val property: Property? = null, val block: Block? = null) {
  init {
    assert(property != null || block != null);
  }
}

public class Resource(type: ResourceType, val name: String, vararg properties: PropertyOrBlock = arrayOf()) : Block(type, *properties)
// ProviderType from name
public class Provider(type: ProviderType, val name: String, vararg properties: PropertyOrBlock = arrayOf()) : Block(type, *properties)

// VariableType from name or use default one
public class Variable(type: VariableType, val name: String, vararg properties: PropertyOrBlock = arrayOf()) : Block(type, *properties)

public object Model {
}
