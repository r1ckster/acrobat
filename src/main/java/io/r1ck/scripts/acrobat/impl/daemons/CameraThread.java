/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.daemons;

import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import org.powerbot.script.Random;

import java.util.logging.Logger;

/**
 * Pitches the camera to the top.
 */
public class CameraThread extends AbstractDaemon {
    private static final Logger logger =
        Logger.getLogger(CameraThread.class.getName());
    
    public CameraThread(final AcrobatContext ctx) {
        super(ctx, "CameraThread");
    }
    
    @Override
    long call() {
        final int pitch = this.ctx.camera.pitch();
        if (pitch < 75) {
            final int newPitch = Random.nextInt(75, 90);
            this.ctx.camera.pitch(newPitch);
            logger.info(String.format("Setting camera pitch to %d.", newPitch));
        }
        return 1000;
    }
}