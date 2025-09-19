package org.raftd.core.node;

import java.io.Serializable;
import javax.annotation.Nonnull;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;


// 集群成员标识
public class NodeId implements Serializable {
    private final String value;

    public NodeId(@Nonnull String value) {
        Preconditions.checkNotNull(value);
        this.value = value;
    }

    public static NodeId of(@Nonnull String value) {
        return new NodeId(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NodeId)) {
            return false;
        }
        NodeId id = (NodeId) o;
        return Objects.equal(value, id.value);
    }

    @Nonnull
    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(value);
    }

    @Override
    public String toString() {
        return this.value;
    }


}
