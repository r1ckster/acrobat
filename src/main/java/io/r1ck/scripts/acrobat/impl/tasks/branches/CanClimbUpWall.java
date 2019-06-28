/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.tasks.branches;

import io.r1ck.meeseeks.tasks.TreeTask;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import io.r1ck.scripts.acrobat.impl.tasks.leaves.ClimbUpWall;

/**
 * Can obstacle 2 be tackled.
 */
public class CanClimbUpWall extends AbstractAcrobatBranch {
    private final ClimbUpWall climbWall;
    private final TreeTask walkLogBeam;

    public CanClimbUpWall(final AcrobatContext ctx) {
        super(ctx);
        this.climbWall = new ClimbUpWall(ctx);
        this.walkLogBeam = new CanWalkLogBeam(ctx);
    }
    
    @Override
    public TreeTask failure() {
        return this.walkLogBeam;
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
