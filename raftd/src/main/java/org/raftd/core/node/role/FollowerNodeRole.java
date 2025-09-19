package org.raftd.core.node.role;

import org.raftd.core.node.NodeId;

public class FollowerNodeRole extends AbstractNodeRole {

    private final NodeId votedFor; // 投票给谁
    private final NodeId leaderId; // leader
    private final ; // 选举超时时间 在这个时间范围内没有收到心跳 就将状态转为候选人
    @Override
    public NodeId getLeaderId(NodeId selfId) {
        return null;
    }

    @Override
    public void cancelTimeoutOrTask() {

    }

    @Override
    public RoleState getStatus() {
        return null;
    }
}
