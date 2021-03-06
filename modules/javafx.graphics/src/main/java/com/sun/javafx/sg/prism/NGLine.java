/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.sun.javafx.sg.prism;

import com.sun.javafx.geom.Line2D;
import com.sun.javafx.geom.Shape;
import com.sun.prism.BasicStroke;
import com.sun.prism.Graphics;

/**
 *
 */
public class NGLine extends NGShape {

    private Line2D line = new Line2D();

    public void updateLine(float x1, float y1, float x2, float y2) {
        line.x1 = x1;
        line.y1 = y1;
        line.x2 = x2;
        line.y2 = y2;
        geometryChanged();
    }

    @Override protected void renderContent2D(Graphics g, boolean printing) {
        if ((mode == Mode.STROKE || mode == Mode.STROKE_FILL) &&
            drawStroke.getLineWidth() > 0 &&
            drawStroke.getType() != BasicStroke.TYPE_INNER)
        {
            g.setPaint(drawPaint);
            g.setStroke(drawStroke);
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }
    }

    @Override
    public final Shape getShape() {
        return line;
    }
}
