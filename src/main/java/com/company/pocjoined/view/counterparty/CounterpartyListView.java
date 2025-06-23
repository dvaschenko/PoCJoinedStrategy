package com.company.pocjoined.view.counterparty;

import com.company.pocjoined.entity.Counterparty;

import com.company.pocjoined.entity.LegalCP;
import com.company.pocjoined.entity.PhysicalCP;
import com.company.pocjoined.view.main.MainView;

import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.core.Messages;
import io.jmix.core.MetadataTools;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "counterparties", layout = MainView.class)
@ViewController(id = "Counterparty.list")
@ViewDescriptor(path = "counterparty-list-view.xml")
@LookupComponent("counterpartiesDataGrid")
@DialogMode(width = "64em")
public class CounterpartyListView extends StandardListView<Counterparty> {
    @Autowired
    private Messages messages;
    @Autowired
    private MetadataTools metadataTools;
    @Autowired
    private DataManager dataManager;

    @Supply(to = "counterpartiesDataGrid.instanceName", subject = "renderer")
    private Renderer<Counterparty> counterpartiesDataGridInstanceNameRenderer() {
        return new TextRenderer<>(cp -> {
            if (cp instanceof PhysicalCP) {
                PhysicalCP reloaded = dataManager.load(PhysicalCP.class)
                        .id(cp.getId())
                        .one();
                return reloaded.getInstanceName(metadataTools);
            } else {
                LegalCP reloaded = dataManager.load(LegalCP.class)
                        .id(cp.getId())
                        .one();
                return reloaded.getName();
            }
        });
    }
}