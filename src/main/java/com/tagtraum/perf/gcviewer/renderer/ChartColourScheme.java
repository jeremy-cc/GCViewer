package com.tagtraum.perf.gcviewer.renderer;

import java.awt.*;
import java.io.IOException;
import java.util.Properties;

/**
 * Permit the user definition of colourschemes; the default one is difficult to understand as colours clash.
 * Created by jeremybotha on 07/03/16.
 */
public class ChartColourScheme {

    private Color defaultLineColour;

    private Color fullMarkColour;
    private Color fullLineColour;
    private Color initialMarkColour;
    private Color incrementalGcLineColour;
    private Color remarkColour;
    private Color vmEventColour;
    private Color concurrentRegionBegin;
    private Color concurrentRegionEnd;
    private Color gcTimeLinesColour;
    private Color gcTimeRectanglesColour;
    private Color totalHeapLineColour;
    private Color totalHeapFillStartColour;
    private Color totalHeapFillEndColour;
    private Color totalTenuredLineColour;
    private Color totalTenuredFillStartColour;
    private Color totalTenuredFillEndColour;
    private Color totalYoungLineColour;
    private Color totalYoungFillStartColour;
    private Color totalYoungFillEndColour;
    private Color usedHeapLineColour;
    private Color usedTenuredLineColour;
    private Color usedTenuredFillColour;
    private Color usedYoungLineColour;

    /*
                * Generate a colour scheme from a property file.
                * */
    public ChartColourScheme(boolean defaultColours) {
        Properties colourScheme = new Properties();

        if (!defaultColours) {
            try {
                colourScheme.load(getClass().getClassLoader().getResourceAsStream("com/tagtraum/perf/gcviewer/chart_colours.properties"));

                defaultLineColour = new Color(Integer.parseInt(colourScheme.getProperty("default_line_colour"), 16));
                fullMarkColour = new Color(Integer.parseInt(colourScheme.getProperty("full_gc_mark_line_colour"), 16));
                fullLineColour = new Color(Integer.parseInt(colourScheme.getProperty("full_gc_line_colour"), 16));
                initialMarkColour = new Color(Integer.parseInt(colourScheme.getProperty("initial_gc_mark_line_colour"), 16));
                incrementalGcLineColour = new Color(Integer.parseInt(colourScheme.getProperty("incremental_gc_line_colour"), 16));
                remarkColour = new Color(Integer.parseInt(colourScheme.getProperty("remark_line_colour"), 16));
                vmEventColour = new Color(Integer.parseInt(colourScheme.getProperty("vm_event_colour"), 16));
                concurrentRegionBegin = new Color(Integer.parseInt(colourScheme.getProperty("concurrent_region_begin_colour"), 16));
                concurrentRegionEnd = new Color(Integer.parseInt(colourScheme.getProperty("concurrent_region_end_colour"), 16));
                gcTimeLinesColour = new Color(Integer.parseInt(colourScheme.getProperty("gc_time_lines_colour"), 16));
                gcTimeRectanglesColour = new Color(Integer.parseInt(colourScheme.getProperty("gc_time_rectangles_colour"), 16));
                totalHeapLineColour = new Color(Integer.parseInt(colourScheme.getProperty("total_heap_outline_colour"), 16));
                totalHeapFillStartColour = new Color(Integer.parseInt(colourScheme.getProperty("total_heap_fill_colour_start"), 16));
                totalHeapFillEndColour = new Color(Integer.parseInt(colourScheme.getProperty("total_heap_fill_colour_end"), 16));
                totalTenuredLineColour = new Color(Integer.parseInt(colourScheme.getProperty("total_tenured_outline_colour"), 16));
                totalTenuredFillStartColour = new Color(Integer.parseInt(colourScheme.getProperty("total_tenured_fill_colour_start"), 16));
                totalTenuredFillEndColour = new Color(Integer.parseInt(colourScheme.getProperty("total_tenured_fill_colour_end"), 16));
                totalYoungLineColour = new Color(Integer.parseInt(colourScheme.getProperty("total_young_outline_colour"), 16));
                totalYoungFillStartColour = new Color(Integer.parseInt(colourScheme.getProperty("total_young_fill_colour_start"), 16));
                totalYoungFillEndColour = new Color(Integer.parseInt(colourScheme.getProperty("total_young_fill_colour_end"), 16));
                usedHeapLineColour = new Color(Integer.parseInt(colourScheme.getProperty("used_heap_outline_colour"), 16));
                usedTenuredLineColour = new Color(Integer.parseInt(colourScheme.getProperty("used_tenured_outline_colour"), 16));
                // alpha blending
                String colourString = colourScheme.getProperty("used_tenured_fill_colour");
                if(colourString.length() > 6) {
                    usedTenuredFillColour = new Color(
                            Integer.valueOf(colourString.substring(0, 2), 16),
                            Integer.valueOf(colourString.substring(2, 4), 16),
                            Integer.valueOf(colourString.substring(4, 6), 16),
                            Integer.valueOf(colourString.substring(6, 8), 16));
                } else {
                    usedTenuredFillColour = new Color(
                            Integer.valueOf(colourString.substring(0, 2), 16),
                            Integer.valueOf(colourString.substring(2, 4), 16),
                            Integer.valueOf(colourString.substring(4, 6), 16));
                }

                usedYoungLineColour = new Color(Integer.parseInt(colourScheme.getProperty("used_young_outline_colour"), 16));
            } catch (IOException ioe) {
                ioe.printStackTrace();
                setDefaultColours();
            }
        } else {
            setDefaultColours();
        }
    }

    private void setDefaultColours() {
        defaultLineColour = Color.BLACK;
        defaultLineColour = Color.GRAY;
        fullMarkColour = Color.BLACK;
        fullLineColour = Color.DARK_GRAY;
        initialMarkColour = Color.BLUE;
        incrementalGcLineColour = Color.CYAN;
        remarkColour = Color.ORANGE;
        vmEventColour = Color.RED;
        concurrentRegionBegin = Color.CYAN;
        concurrentRegionEnd = Color.PINK;
        gcTimeLinesColour = Color.GREEN;
        gcTimeRectanglesColour = Color.LIGHT_GRAY;
        totalHeapLineColour = Color.BLACK;
        totalHeapFillStartColour = Color.BLUE;
        totalHeapFillEndColour = Color.WHITE;
        totalTenuredLineColour = Color.MAGENTA;
        totalTenuredFillStartColour = Color.MAGENTA;
        totalTenuredFillEndColour = Color.WHITE;
        totalYoungLineColour = Color.ORANGE;
        totalYoungFillStartColour = Color.YELLOW;
        totalYoungFillEndColour = Color.WHITE;
        usedHeapLineColour = Color.CYAN;
        usedTenuredLineColour = Color.MAGENTA;
        usedTenuredFillColour = new Color(220, 60, 220, 128);
        usedYoungLineColour = Color.ORANGE;
    }

    public Color getDefaultLineColour() {
        return defaultLineColour;
    }

    public Color getFullMarkColour() {
        return fullMarkColour;
    }

    public Color getInitialMarkColour() {
        return initialMarkColour;
    }

    public Color getIncrementalGcLineColour() {
        return incrementalGcLineColour;
    }

    public Color getRemarkColour() {
        return remarkColour;
    }

    public Color getVmEventColour() {
        return vmEventColour;
    }

    public Color getConcurrentRegionBegin() {
        return concurrentRegionBegin;
    }

    public Color getConcurrentRegionEnd() {
        return concurrentRegionEnd;
    }

    public Color getGcTimeLinesColour() {
        return gcTimeLinesColour;
    }

    public Color getGcTimeRectanglesColour() {
        return gcTimeRectanglesColour;
    }

    public Color getFullLineColour() {
        return fullLineColour;
    }

    public Color getTotalHeapFillStartColour() {
        return totalHeapFillStartColour;
    }

    public Color getTotalHeapLineColour() {
        return totalHeapLineColour;
    }

    public Color getTotalHeapFillEndColour() {
        return totalHeapFillEndColour;
    }

    public Color getTenuredFillStartColour() {
        return totalTenuredFillStartColour;
    }

    public Color getTenuredLineColour() {
        return totalTenuredLineColour;
    }

    public Color getTenuredFillEndColour() {
        return totalTenuredFillEndColour;
    }

    public Color getYoungFillStartColour() {
        return totalYoungFillStartColour;
    }

    public Color getYoungLineColour() {
        return totalYoungLineColour;
    }

    public Color getYoungFillEndColour() {
        return totalYoungFillEndColour;
    }


    public Color getUsedHeapLineColour() {
        return usedHeapLineColour;
    }


    public Color getUsedTenuredLineColour() {
        return usedTenuredLineColour;
    }

    public Color getUsedTenuredFillColour() {
        return usedTenuredFillColour;
    }

    public Color getUsedYoungLineColour() {
        return usedYoungLineColour;
    }


}
