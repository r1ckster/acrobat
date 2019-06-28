/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.tasks.branches;

import io.r1ck.meeseeks.tasks.TreeTask;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import io.r1ck.scripts.acrobat.impl.context.accessor.AcrobatAccessor;

/**
 * Abstract task branch.
 */
abstract class AbstractAcrobatBranch extends AcrobatAccessor implements TreeTask {
    AbstractAcrobatBranch(final AcrobatContext ctx) {
        super(ctx);
    }
    
    @Override
    public void execute() {
        throw new UnsupportedOperationException("Branches cannot be executed.");
    }
    
    @Override
    public boolean leaf() {
        return false;
    }
    
    @Override
    public String name() {
        throw new UnsupportedOperationException("Branches do not have names.");
    }
}
