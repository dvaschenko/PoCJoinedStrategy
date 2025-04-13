package com.company.pocjoined.view.contract;

import com.company.pocjoined.entity.Contract;
import com.company.pocjoined.view.main.MainView;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.Route;
import io.jmix.core.MessageTools;
import io.jmix.core.Metadata;
import io.jmix.core.MetadataTools;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "contracts", layout = MainView.class)
@ViewController(id = "Contract.list")
@ViewDescriptor(path = "contract-list-view.xml")
@LookupComponent("contractsDataGrid")
@DialogMode(width = "64em")
public class ContractListView extends StandardListView<Contract> {
    @Autowired
    private MessageTools messageTools;
    @Autowired
    private Metadata metadata;
    @Autowired
    private MetadataTools metadataTools;

    @Supply(to = "contractsDataGrid.counterparty", subject = "renderer")
    private Renderer<Contract> contractsDataGridCounterpartyRenderer() {
      return new TextRenderer<>(contract ->
        metadataTools.getInstanceName(contract.getCounterparty()));
    }
}