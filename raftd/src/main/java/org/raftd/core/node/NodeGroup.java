package org.raftd.core.node;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// 每个节点持有的集群列表
@NotThreadSafe
class NodeGroup {

    private static final Logger logger = LoggerFactory.getLogger(NodeGroup.class);
    private final NodeId selfId; // 节点自身
    private Map<NodeId, GroupMember> memberMap;

    NodeGroup(NodeEndpoint endpoint) {
        this(Collections.singleton(endpoint), endpoint.getId());
    }

    NodeGroup(Collection<NodeEndpoint> endpoints, NodeId selfId) {
        this.selfId = selfId;
    }


    private Map<NodeId, GroupMember> buildMemberMap(Collection<NodeEndpoint> endpoints) {
        Map<NodeId, GroupMember> map = new HashMap<>();
        for (NodeEndpoint endpoint : endpoints) {
            map.put(endpoint.getId(), new GroupMember(endpoint));
        }
        if (map.isEmpty()) {
            throw new IllegalArgumentException("endpoints is empty");
        }
        return map;
    }


    GroupMember findSelf() {
        return findMember(selfId);
    }

    GroupMember findMember(NodeId id) {
        GroupMember member = getMember(id);
        if (member == null) {
            throw new IllegalArgumentException("no such node " + id);
        }
        return member;
    }


    GroupMember getMember(NodeId id) {
        return memberMap.get(id);
    }

    boolean isMemberOfMajor(NodeId id) {
        GroupMember member = memberMap.get(id);
        return member != null && member.isMajor();
    }
}
