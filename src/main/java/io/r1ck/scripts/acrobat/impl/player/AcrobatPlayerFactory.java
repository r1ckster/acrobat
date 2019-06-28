/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.player;

import io.r1ck.scripts.acrobat.api.player.AcrobatPlayer;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;

public final class AcrobatPlayerFactory {
    private static AcrobatPlayer instance;
    
    private AcrobatPlayerFactory() {
    }
    
    public synchronized static AcrobatPlayer instance(final AcrobatContext ctx) {
        if (instance == null) {
            instance = new AcrobatPlayerImpl(ctx);
        }
        return instance;
    }
}
