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
 * Obstacle 6: Swing across the Monkey bars.
 */
public class SwingMonkeyBars extends AbstractAcrobatLeaf {
    private static final String MONKEY_BARS = "Monkey bars";
    private static final String SWING = "Swing-across";
    
    private static final Tile tile = new Tile(2917, 3560, 1);
    
    public SwingMonkeyBars(final AcrobatContext ctx) {
        super(ctx, MONKEY_BARS, SWING, tile);
    }
    
    @Override
    public String name() {
        return "Swinging across the Monkey bars.";
    }
    
    @Override
    protected Area obstacleArea() {
        return RectangleAreaFactory.create(
            this.ctx,
            new Tile(2916, 3561, 1),
            2, 3
        );
    }
}
