/**
 * This file is licensed under MIT
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Jonas Gehring
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.intl.aaa.survey;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.intl.aaa.survey.GraphActivity;

/**
 * Created by jonas on 28.08.14.
 */
public class StylingBarGraph extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        int x1 = 0;
        int y1 = 1;

        int x2 = 1;
        int y2 = 5;

        int x3 = 2;
        int y3 = 2;

        int x4 = 3;
        int y4 = 2;

        int x5 = 4;
        int y5 = 6;
        graph.setBackgroundColor(Color.WHITE);  //add
        BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[] {
/*                new DataPoint(0, -1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)*/
                new DataPoint(0, y1),
                new DataPoint(1, y2),
                new DataPoint(2, y3),
                new DataPoint(3, y4),
                new DataPoint(4, y5)
        });
        graph.addSeries(series);

        // styling
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/6, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        series.setSpacing(80);

        // draw values on top
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);
        //series.setValuesOnTopSize(50);

        // legend
        series.setTitle("foo");
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
//        graph.getViewport().setYAxisBoundsManual(true);
//        graph.getViewport().setMinY(20);    //add
//        graph.getViewport().setMaxY(8);     //add
        return rootView;
    }
/*

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((GraphActivity) activity).onSectionAttached(
                getArguments().getInt(GraphActivity.ARG_SECTION_NUMBER));
    }
*/

}
