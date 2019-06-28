/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.context.accessor;

import io.r1ck.meeseeks.context.accessor.AbstractAccessor;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;

public abstract class AcrobatAccessor extends AbstractAccessor<AcrobatContext> {
    public final AcrobatContext ctx;
    
    protected AcrobatAccessor(final AcrobatContext ctx) {
        super(ctx);
        this.ctx = ctx;
    }
}
