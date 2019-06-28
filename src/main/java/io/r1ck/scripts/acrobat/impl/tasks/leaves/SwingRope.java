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
 * Obstacle 5: Swing on the rope swing.
 */
public class SwingRope extends AbstractAcrobatLeaf {
    private static final String ROPE = "Rope swing";
    private static final String SWING = "Swing-on";
    
    private static final Tile tile = new Tile(2914, 3562, 1);
    
    public SwingRope(final AcrobatContext ctx) {
        super(ctx, ROPE, SWING, tile);
    }
    
    @Override
    public String name() {
        return "Swinging on the rope swing.";
    }
    
    @Override
    protected Area obstacleArea() {
        return RectangleAreaFactory.create(
            this.ctx,
            new Tile(2912, 3561, 1),
            1, 3
        );
    }
}
