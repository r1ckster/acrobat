/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.tasks.branches;

import io.r1ck.meeseeks.tasks.TreeTask;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import io.r1ck.scripts.acrobat.impl.tasks.leaves.SwingRope;

/**
 * Can obstacle 5 be tackled.
 */
public class CanSwingRope extends AbstractAcrobatBranch {
    private final TreeTask climbWall;
    private final SwingRope swingRope;

    public CanSwingRope(final AcrobatContext ctx) {
        super(ctx);
        this.climbWall = new CanClimbOverWall(ctx);
        this.swingRope = new SwingRope(ctx);
    }
    
    @Override
    public TreeTask failure() {
        return this.climbWall;
    }
    
    @Override
    public TreeTask success() {
        return this.swingRope;
    }
    
    @Override
    public boolean valid() {
        return this.swingRope.valid();
    }
}
