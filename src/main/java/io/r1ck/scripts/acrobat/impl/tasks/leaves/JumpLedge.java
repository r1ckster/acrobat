/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.tasks.leaves;

import io.r1ck.meeseeks.areas.Area;
import io.r1ck.meeseeks.areas.rectangle.RectangleAreaFactory;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import org.powerbot.script.Tile;

/**
 * Obstacle 7: Jump down the ledge.
 */
public class JumpLedge extends AbstractAcrobatLeaf {
    private static final String JUMP = "Jump-down";
    private static final String LEDGE = "Ledge";
    
    private static final Tile tile = new Tile(2916, 3553, 1);
    
    public JumpLedge(final AcrobatContext ctx) {
        super(ctx, LEDGE, JUMP, tile);
    }
    
    @Override
    public String name() {
        return "Jumping down the ledge.";
    }
    
    @Override
    protected Area obstacleArea() {
        return RectangleAreaFactory.create(
            this.ctx,
            new Tile(2915, 3553, 1),
            3, 2
        );
    }
}
