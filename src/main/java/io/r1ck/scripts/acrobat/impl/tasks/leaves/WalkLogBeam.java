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
 * Obstacle 1: Walk the log beam.
 */
public class WalkLogBeam extends AbstractAcrobatLeaf {
    private static final String LOG_BEAM = "Log beam";
    private static final String WALK = "Walk";
    
    private static final Tile tile = new Tile(2919, 3555, 0);
    
    public WalkLogBeam(final AcrobatContext ctx) {
        super(ctx, LOG_BEAM, WALK, tile);
    }
    
    @Override
    public String name() {
        return "Walking the log beam";
    }
    
    @Override
    protected Area obstacleArea() {
        return AbsoluteAreaBuilder.init(this.ctx)
            .addRectangular(new Tile(2913, 3553, 0), 3, 9)
            .addRectangular(new Tile(2913, 3551, 0), 9, 2)
            .build();
    }
}
