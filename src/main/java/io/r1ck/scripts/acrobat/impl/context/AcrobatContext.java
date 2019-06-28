/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.context;

import io.r1ck.meeseeks.context.AbstractContext;
import io.r1ck.meeseeks.context.Context;
import io.r1ck.scripts.acrobat.api.player.AcrobatPlayer;
import io.r1ck.scripts.acrobat.impl.player.AcrobatPlayerFactory;
import org.powerbot.script.rt6.ClientContext;

public class AcrobatContext extends AbstractContext<AcrobatPlayer> implements Context<AcrobatPlayer> {
    public AcrobatContext(final ClientContext ctx) {
        super(ctx);
    }
    
    @Override
    protected AcrobatPlayer getPlayer() {
        return AcrobatPlayerFactory.instance(this);
    }
}
