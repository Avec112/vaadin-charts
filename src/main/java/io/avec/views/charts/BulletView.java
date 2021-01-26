package io.avec.views.charts;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.charts.model.style.SolidColor;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import io.avec.views.main.MainView;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;


@Route(value = "chart-bullet", layout = MainView.class)
@PageTitle("Chart Bullet")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class BulletView extends VerticalLayout {

    public BulletView() {
        setId("hello-world-view");

        // Create a bullet chart
        Chart chart = new Chart(ChartType.BULLET);
        chart.setHeight("115px");

        // Modify the default configuration
        Configuration conf = chart.getConfiguration();
        conf.setTitle("2020 YTD");
        conf.getChart().setInverted(true);
        conf.getLegend().setEnabled(false);
        conf.getTooltip().setPointFormat(
                "<b>{point.y}</b> (with target at {point.target})");

        // Add data
        PlotOptionsBullet options = new PlotOptionsBullet();
        options.setPointPadding(0.25);
        options.setBorderWidth(0);
        options.setColor(SolidColor.BLACK);
        options.getTargetOptions().setWidth("200%");
        DataSeries series = new DataSeries();
        series.add(new DataSeriesItemBullet(275, 250));
        series.setPlotOptions(options);
        conf.addSeries(series);

        // Configure the axes
        YAxis yAxis = conf.getyAxis();
        yAxis.setGridLineWidth(0);
        yAxis.setTitle("");
        yAxis.addPlotBand(new PlotBand(0, 150, new SolidColor("#666666")));
        yAxis.addPlotBand(new PlotBand(150, 225, new SolidColor("#999999")));
        yAxis.addPlotBand(new PlotBand(225, 9e9, new SolidColor("#bbbbbb")));
        conf.getxAxis().addCategory(
                "<span style=\"font-size: 13px; font-weight: bold;\">Revenue</span><br/>U.S. $ (1,000s)");

        add(chart);

    }

}
