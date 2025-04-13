package com.company.pocjoined.view.legalcp;

import com.company.pocjoined.entity.LegalCP;
import com.company.pocjoined.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "legal-cps/:id", layout = MainView.class)
@ViewController(id = "LegalCP.detail")
@ViewDescriptor(path = "legal-cp-detail-view.xml")
@EditedEntityContainer("legalCPDc")
public class LegalCPDetailView extends StandardDetailView<LegalCP> {
}