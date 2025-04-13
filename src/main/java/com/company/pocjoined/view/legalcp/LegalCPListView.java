package com.company.pocjoined.view.legalcp;

import com.company.pocjoined.entity.Counterparty;
import com.company.pocjoined.entity.LegalCP;
import com.company.pocjoined.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "legal-cps", layout = MainView.class)
@ViewController(id = "LegalCP.list")
@ViewDescriptor(path = "legal-cp-list-view.xml")
@LookupComponent("legalCPsDataGrid")
@DialogMode(width = "64em")
public class LegalCPListView extends StandardListView<LegalCP> {
}