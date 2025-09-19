package org.raftd.core.node.role;

import org.raftd.core.node.NodeId;

// 抽象的节点角色
public abstract class AbstractNodeRole {

    private final RoleName name;
    protected final int term;

    AbstractNodeRole(RoleName name, int term) {
        this.name = name;
        this.term = term;
    }

    public RoleName getName() {
        return name;
    }

    public int getTerm() {
        return term;
    }

    public abstract NodeId getLeaderId(NodeId selfId);

    // 角色转换前将自身的一些延迟任务取消掉
    public abstract void cancelTimeoutOrTask();

    public abstract RoleState getStatus();
}
