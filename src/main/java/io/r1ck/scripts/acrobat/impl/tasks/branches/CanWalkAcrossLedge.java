/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.tasks.branches;

import io.r1ck.meeseeks.tasks.TreeTask;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import io.r1ck.scripts.acrobat.impl.tasks.leaves.WalkAcrossLedge;

/**
 * Can obstacle 3 be tackled.
 */
public class CanWalkAcrossLedge extends AbstractAcrobatBranch {
    private final TreeTask climbUpWall;
    private final WalkAcrossLedge walkAcrossLedge;

    public CanWalkAcrossLedge(final AcrobatContext ctx) {
        super(ctx);
        this.climbUpWall = new CanClimbUpWall(ctx);
        this.walkAcrossLedge = new WalkAcrossLedge(ctx);
    }
    
    @Override
    public TreeTask failure() {
        return this.climbUpWall;
    }
    
    @Override
    public TreeTask success() {
        return this.walkAcrossLedge;
    }
    
    @Override
    public boolean valid() {
        return this.walkAcrossLedge.valid();
    }
}
