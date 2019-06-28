/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.tasks.branches;

import io.r1ck.meeseeks.tasks.TreeTask;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import io.r1ck.scripts.acrobat.impl.tasks.leaves.WalkLogBeam;

/**
 * Can obstacle 1 be tackled.
 */
public class CanWalkLogBeam extends AbstractAcrobatBranch {
    private final WalkLogBeam walkLogBeam;

    public CanWalkLogBeam(final AcrobatContext ctx) {
        super(ctx);
        this.walkLogBeam = new WalkLogBeam(ctx);
    }
    
    @Override
    public TreeTask failure() {
        return NIL;
    }
    
    @Override
    public TreeTask success() {
        return this.walkLogBeam;
    }
    
    @Override
    public boolean valid() {
        return this.walkLogBeam.valid();
    }
}
