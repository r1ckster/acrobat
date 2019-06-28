/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.tasks.branches;

import io.r1ck.meeseeks.tasks.TreeTask;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import io.r1ck.scripts.acrobat.impl.tasks.leaves.JumpLedge;

/**
 * Can obstacle 7 be tackled.
 */
public class CanJumpLedge extends AbstractAcrobatBranch {
    private final JumpLedge jumpLedge;
    private final TreeTask swingMonkeyBars;

    public CanJumpLedge(final AcrobatContext ctx) {
        super(ctx);
        this.jumpLedge = new JumpLedge(ctx);
        this.swingMonkeyBars = new CanSwingMonkeyBars(ctx);
    }
    
    @Override
    public TreeTask failure() {
        return this.swingMonkeyBars;
    }
    
    @Override
    public TreeTask success() {
        return this.jumpLedge;
    }
    
    @Override
    public boolean valid() {
        return this.jumpLedge.valid();
    }
}
