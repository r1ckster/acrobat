/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat;

import io.r1ck.meeseeks.TreeScript;
import io.r1ck.meeseeks.tasks.TreeTask;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import io.r1ck.scripts.acrobat.impl.daemons.CameraThread;
import io.r1ck.scripts.acrobat.impl.tasks.branches.CanJumpLedge;
import org.powerbot.script.Script;

@Script.Manifest(name = "Acrobat", description = "Completes the Burthorpe Agility course.", properties = "client=6;")
public class Acrobat extends TreeScript<AcrobatContext> {
    private CameraThread cameraThread;
    private TreeTask tree;
    
    @Override
    protected TreeTask rootTask() {
        return this.tree;
    }
    
    @Override
    public void start() {
        this.cameraThread = new CameraThread(this.ctx);
        
        this.tree = new CanJumpLedge(this.ctx);
        
        this.cameraThread.start();
    }
    
    @Override
    public void stop() {
        if (this.cameraThread != null) {
            this.cameraThread.stop();
        }
    }
}
