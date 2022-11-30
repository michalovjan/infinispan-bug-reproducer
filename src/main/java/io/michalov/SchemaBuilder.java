package io.michalov;

import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder("io.michalov")
public interface SchemaBuilder extends SerializationContextInitializer {
}
