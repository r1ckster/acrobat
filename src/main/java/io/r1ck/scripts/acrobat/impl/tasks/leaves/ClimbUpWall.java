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
 * Obstacle 2: Climb up the wall.
 */
public class ClimbUpWall extends AbstractAcrobatLeaf {
    private static final String CLIMB_UP = "Climb-up";
    private static final String WALL = "Wall";
    
    private static final Tile tile = new Tile(2919, 3561, 0);
    
    public ClimbUpWall(final AcrobatContext ctx) {
        super(ctx, WALL, CLIMB_UP, tile);
    }
    
    @Override
    public String name() {
        return "Climbing up the wall";
    }
    
    @Override
    protected Area obstacleArea() {
        return AbsoluteAreaBuilder.init(this.ctx)
            .addRectangular(new Tile(2921, 3554, 0), 1, 4)
            .addRectangular(new Tile(2918, 3558, 0), 4, 4)
            .addRectangular(new Tile(2921, 3562, 0), 1, 3)
            .build();
    }
}
