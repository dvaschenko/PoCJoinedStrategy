package com.company.pocjoined.view.physicalcp;

import com.company.pocjoined.entity.PhysicalCP;
import com.company.pocjoined.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "physical-cps/:id", layout = MainView.class)
@ViewController(id = "PhysicalCP.detail")
@ViewDescriptor(path = "physical-cp-detail-view.xml")
@EditedEntityContainer("physicalCPDc")
public class PhysicalCPDetailView extends StandardDetailView<PhysicalCP> {
}