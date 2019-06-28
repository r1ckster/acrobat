/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.player;

import io.r1ck.meeseeks.areas.Area;
import io.r1ck.meeseeks.player.AbstractPlayer;
import io.r1ck.scripts.acrobat.api.player.AcrobatPlayer;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import org.powerbot.script.Condition;
import org.powerbot.script.InteractiveEntity;

import java.util.concurrent.Callable;

class AcrobatPlayerImpl extends AbstractPlayer<AcrobatContext> implements AcrobatPlayer {
    AcrobatPlayerImpl(final AcrobatContext ctx) {
        super(ctx);
    }
    
    @Override
    public boolean in(final Area area) {
        return area != null && area.contains(this);
    }
    
    @Override
    public void interact(final InteractiveEntity entity,
                         final String action,
                         final Callable<Boolean> condition) {
        this.ctx.camera.turnTo(entity);
        
        if (entity.interact(action)) {
            Condition.wait(condition, 500, 10);
        } else if (this.distanceTo(entity) > 3.0D && !this.moving()) {
            this.walk(entity);
        }
    }
}
