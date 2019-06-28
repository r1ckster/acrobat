/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.tasks.branches;

import io.r1ck.meeseeks.tasks.TreeTask;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import io.r1ck.scripts.acrobat.impl.tasks.leaves.SwingMonkeyBars;

/**
 * Can obstacle 6 be tackled.
 */
public class CanSwingMonkeyBars extends AbstractAcrobatBranch {
    private final SwingMonkeyBars swingMonkeyBars;
    private final TreeTask swingRope;

    public CanSwingMonkeyBars(final AcrobatContext ctx) {
        super(ctx);
        this.swingMonkeyBars = new SwingMonkeyBars(ctx);
        this.swingRope = new CanSwingRope(ctx);
    }
    
    @Override
    public TreeTask failure() {
        return this.swingRope;
    }
    
    @Override
    public TreeTask success() {
        return this.swingMonkeyBars;
    }
    
    @Override
    public boolean valid() {
        return this.swingMonkeyBars.valid();
    }
}
