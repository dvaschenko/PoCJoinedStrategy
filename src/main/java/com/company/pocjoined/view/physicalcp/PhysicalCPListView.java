package com.company.pocjoined.view.physicalcp;

import com.company.pocjoined.entity.Counterparty;
import com.company.pocjoined.entity.PhysicalCP;
import com.company.pocjoined.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "physical-cps", layout = MainView.class)
@ViewController(id = "PhysicalCP.list")
@ViewDescriptor(path = "physical-cp-list-view.xml")
@LookupComponent("physicalCPsDataGrid")
@DialogMode(width = "64em")
public class PhysicalCPListView extends StandardListView<PhysicalCP> {
}