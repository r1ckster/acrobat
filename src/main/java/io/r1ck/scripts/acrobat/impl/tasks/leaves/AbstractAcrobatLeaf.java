/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.tasks.leaves;

import io.r1ck.meeseeks.areas.Area;
import io.r1ck.meeseeks.tasks.TreeTask;
import io.r1ck.scripts.acrobat.api.player.AcrobatPlayer;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import io.r1ck.scripts.acrobat.impl.context.accessor.AcrobatAccessor;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.GameObject;

import java.util.Optional;
import java.util.concurrent.Callable;

/**
 * Abstract task leaf.
 */
abstract class AbstractAcrobatLeaf extends AcrobatAccessor implements TreeTask {
    private final String obstacleAction;
    private final Area obstacleArea;
    private final String obstacleName;
    private final Tile obstacleTile;
    private GameObject obstacle;
    
    protected final AcrobatPlayer player;
    
    AbstractAcrobatLeaf(final AcrobatContext ctx,
                        final String obstacle,
                        final String obstacleAction,
                        final Tile obstacleTile) {
        super(ctx);
        this.obstacleAction = obstacleAction;
        this.obstacleArea = this.obstacleArea();
        this.obstacleName = obstacle;
        this.obstacleTile = obstacleTile;
        this.obstacle = this.obstacle();
        this.player = ctx.player();
    }
    
    @Override
    public void execute() {
        this.tackleObstacle(() ->
            this.ctx.player().idle() && !this.valid()
        );
    }
    
    @Override
    public TreeTask failure() {
        return NIL;
    }
    
    @Override
    public boolean leaf() {
        return true;
    }
    
    public GameObject obstacle() {
        if (this.obstacle == null || !this.obstacle.valid()) {
            this.obstacle = this.ctx.objects.select()
                .name(this.obstacleName)
                .action(this.obstacleAction)
                .at(this.obstacleTile)
                .poll();
        }
        return this.obstacle;
    }
    
    abstract protected Area obstacleArea();
    
    @Override
    public TreeTask success() {
        return NIL;
    }
    
    /**
     * Tackles the given obstacle.
     *
     * @param done validates that the obstacle was tackled
     */
    protected void tackleObstacle(final Callable<Boolean> done) {
        Optional.ofNullable(this.obstacle()).ifPresent(
            obs -> this.player.interact(obs, this.obstacleAction, done)
        );
    }
    
    @Override
    public boolean valid() {
        return this.obstacle().valid() && this.player.in(this.obstacleArea);
    }
}
