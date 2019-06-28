/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author r1ck
 */
package io.r1ck.scripts.acrobat.api.player;

import io.r1ck.meeseeks.areas.Area;
import io.r1ck.meeseeks.player.Player;

public interface AcrobatPlayer extends Player {
    boolean in(Area area);
}
