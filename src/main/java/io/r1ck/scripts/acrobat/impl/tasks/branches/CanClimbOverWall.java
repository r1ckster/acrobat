/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.tasks.branches;

import io.r1ck.meeseeks.tasks.TreeTask;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import io.r1ck.scripts.acrobat.impl.tasks.leaves.ClimbOverWall;

/**
 * Can obstacle 4 be tackled.
 */
public class CanClimbOverWall extends AbstractAcrobatBranch {
    private final ClimbOverWall climbWall;
    private final TreeTask walkAcrossLedge;

    public CanClimbOverWall(final AcrobatContext ctx) {
        super(ctx);
        this.climbWall = new ClimbOverWall(ctx);
        this.walkAcrossLedge = new CanWalkAcrossLedge(ctx);
    }
    
    @Override
    public TreeTask failure() {
        return this.walkAcrossLedge;
    }
    
    @Override
    public TreeTask success() {
        return this.climbWall;
    }
    
    @Override
    public boolean valid() {
        return this.climbWall.valid();
    }
}
