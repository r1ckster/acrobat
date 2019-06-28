/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.impl.tasks.leaves;

import io.r1ck.meeseeks.areas.Area;
import io.r1ck.meeseeks.areas.absolute.AbsoluteAreaBuilder;
import io.r1ck.scripts.acrobat.impl.context.AcrobatContext;
import org.powerbot.script.Tile;

/**
 * Obstacle 3: Walk across the balancing ledge.
 */
public class WalkAcrossLedge extends AbstractAcrobatLeaf {
    private static final String LEDGE = "Balancing ledge";
    private static final String WALK_ACROSS = "Walk-across";
    
    private static final Tile tile = new Tile(2915, 3564, 1);
    
    public WalkAcrossLedge(final AcrobatContext ctx) {
        super(ctx, LEDGE, WALK_ACROSS, tile);
    }
    
    @Override
    public String name() {
        return "Walking across the balancing ledge";
    }
    
    @Override
    protected Area obstacleArea() {
        return AbsoluteAreaBuilder.init(this.ctx)
            .addRectangular(new Tile(2918, 3562, 1), 3, 3)
            .addRectangular(new Tile(2916, 3564, 1), 3, 1)
            .build();
    }
}
