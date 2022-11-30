package io.michalov;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

import java.util.Objects;

public class Data {

    @ProtoField(1)
    public String getText() {
        return text;
    }

    private final String text;

    @ProtoFactory
    public Data(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data data)) return false;
        return Objects.equals(text, data.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
