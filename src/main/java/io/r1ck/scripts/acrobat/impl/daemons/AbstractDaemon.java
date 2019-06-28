/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.daemons;

import io.r1ck.meeseeks.Daemon;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import io.r1ck.scripts.acrobat.impl.context.accessor.AcrobatAccessor;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

abstract class AbstractDaemon extends AcrobatAccessor implements Daemon {
    private final String name;
    private final AtomicBoolean running;
    private final AtomicReference<Thread> thread;
    
    AbstractDaemon(final AcrobatContext ctx, final String name) {
        super(ctx);
        this.name = name;
        this.running = new AtomicBoolean(false);
        this.thread = new AtomicReference<>(new Thread(this, name));
    }
    
    /**
     * Runs the daemon task.
     *
     * @return the amount of milliseconds to wait until the next run
     */
    abstract long call();
    
    @Override
    public String name() {
        return this.name;
    }
    
    /**
     * Action to be executed when the thread is started.
     */
    void onStart() {
    
    }
    
    @Override
    public void run() {
        this.onStart();
        while (!Thread.interrupted()) {
            try {
                if (this.ctx.controller.isStopping() || !this.running.get()) {
                    this.thread.get().interrupt();
                    break;
                }
                Thread.sleep(this.call());
            } catch (final InterruptedException ignored) {
                break;
            }
        }
        this.thread.get().interrupt();
    }
    
    @Override
    public void start() {
        this.running.set(true);
        this.thread.get().start();
    }
    
    @Override
    public void stop() {
        this.running.set(false);
    }
}