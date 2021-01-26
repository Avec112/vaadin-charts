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


@Route(value = "chart-organization", layout = MainView.class)
@PageTitle("Chart Organization")
@CssImport("./styles/views/helloworld/hello-world-view.css")
//@RouteAlias(value = "", layout = MainView.class)
public class OrganizationView extends VerticalLayout {

    public OrganizationView() {
        setId("hello-world-view");


        Chart chart = new Chart(ChartType.ORGANIZATION);
        Configuration conf = chart.getConfiguration();
        conf.getChart().setInverted(true);
        conf.getChart().setHeight("600px");
        conf.getTooltip().setOutside(true);
        conf.setTitle("Acme organization chart");


        PlotOptionsOrganization plotOptions = new PlotOptionsOrganization();
        plotOptions.setColorByPoint(false);
        plotOptions.setColor(new SolidColor("#007ad0"));

//Special color for first level
        Level level0 = new Level();
        level0.setLevel(0);
        level0.setColor(new SolidColor("#99AED3"));
        plotOptions.addLevel(level0);
        conf.setPlotOptions(plotOptions);
        add(chart);

        NodeSeries series = new NodeSeries();
        series.setName("Acme");
        Node acme = new Node("Acme");
        acme.setLayout(NodeLayout.HANGING);
        Node headOffice = new Node("Head Office");
//        headOffice.setLayout(NodeLayout.HANGING);
        Node labs = new Node("Labs");
        Node coyoteBuilding = new Node("Coyote Building");
//        coyoteBuilding.setLayout(NodeLayout.HANGING);
        Node roadRunnerBuilding = new Node("Road Runner Building");
        Node sales = new Node("Sales");
        Node marketing = new Node("Marketing");
        Node accounting = new Node("Accounting");
        Node administration = new Node("Administration");
        Node mdsOffice = new Node("MD's Office");

        Node josephMiler = new Node("Joseph Miler");
        josephMiler.setTitle("Head of Sales");
        josephMiler.setLayout(NodeLayout.HANGING);

        Node erikPerez = new Node("Erik Perez");
        erikPerez.setTitle("Head of Marketing");
        erikPerez.setLayout(NodeLayout.HANGING);

        Node emilyFox = new Node("Emily Fox");
        emilyFox.setTitle("Head of Accounting");

        Node ewanHerbert = new Node("Ewan Herbert");
        ewanHerbert.setTitle("Head of Admin");
        ewanHerbert.setLayout(NodeLayout.HANGING);

        Node kateKirby = new Node("Kate Kirby");
        Node vaughnWhiting = new Node("Vaughn Whiting");
        Node lisaWarner = new Node("Lisa Warner");
        Node lisaGarner = new Node("Lisa Garner");
        Node mollyDodd = new Node("Molly Dodd");
        Node natashaKelly = new Node("Natasha Kelly");

//Set color for a specific Node
        Node managingDirector = new Node("Sally Brown", "Sally Brown",
                "Managing Director");
        managingDirector.setColor(new SolidColor("#E4B651"));

        series.add(acme, labs);
        series.add(acme, headOffice);
        series.add(headOffice, coyoteBuilding);
        series.add(headOffice, roadRunnerBuilding);
        series.add(coyoteBuilding, sales);
        series.add(coyoteBuilding, marketing);
        series.add(coyoteBuilding, accounting);
        series.add(roadRunnerBuilding, administration);
        series.add(roadRunnerBuilding, mdsOffice);
        series.add(sales, josephMiler);
        series.add(marketing, erikPerez);
        series.add(accounting, emilyFox);
        series.add(administration, ewanHerbert);
        series.add(josephMiler, kateKirby);
        series.add(josephMiler, vaughnWhiting);
        series.add(erikPerez, lisaWarner);
        series.add(erikPerez, lisaGarner);
        series.add(ewanHerbert, mollyDodd);
        series.add(ewanHerbert, natashaKelly);
        series.add(mdsOffice, managingDirector);
        conf.addSeries(series);

        add(chart);
    }


}