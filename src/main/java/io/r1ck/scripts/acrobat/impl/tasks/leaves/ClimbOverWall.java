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
 * Obstacle 4: Climb over the obstacle low wall.
 */
public class ClimbOverWall extends AbstractAcrobatLeaf {
    private static final String CLIMB_OVER = "Climb-over";
    private static final String WALL = "Obstacle low wall";

    private static final Tile tile = new Tile(2911, 3562, 1);
    
    public ClimbOverWall(final AcrobatContext ctx) {
        super(ctx, WALL, CLIMB_OVER, tile);
    }
    
    @Override
    public String name() {
        return "Climbing over the obstacle low wall";
    }
    
    @Override
    protected Area obstacleArea() {
        return AbsoluteAreaBuilder.init(this.ctx)
            .addRectangular(new Tile(2910, 3564, 1), 3, 1)
            .addRectangular(new Tile(2910, 3561, 1), 1, 3)
            .build();
    }
}
