package org.raftd.core.node;

// 集群每个节点的状态
public class GroupMember {
    private final NodeEndpoint endpoint;
    private ReplicatingState replicatingState;
    private boolean major; // 是否是leader
    private boolean removing = false;// 是否正在被移除

    GroupMember(NodeEndpoint endpoint) {
        this(endpoint, null, true);
    }

    GroupMember(NodeEndpoint endpoint, ReplicatingState replicatingState, boolean major) {
        this.endpoint = endpoint;
        this.replicatingState = replicatingState;
        this.major = major;
    }

    boolean isMajor() {
        return this.major;
    }

}
