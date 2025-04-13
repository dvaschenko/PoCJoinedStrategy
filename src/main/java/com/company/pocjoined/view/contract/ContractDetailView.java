package com.company.pocjoined.view.contract;

import com.company.pocjoined.entity.*;
import com.company.pocjoined.view.legalcp.LegalCPListView;
import com.company.pocjoined.view.main.MainView;
import com.company.pocjoined.view.physicalcp.PhysicalCPListView;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.DialogWindows;
import io.jmix.flowui.component.select.JmixSelect;
import io.jmix.flowui.component.valuepicker.EntityPicker;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "contracts/:id", layout = MainView.class)
@ViewController(id = "Contract.detail")
@ViewDescriptor(path = "contract-detail-view.xml")
@EditedEntityContainer("contractDc")
public class ContractDetailView extends StandardDetailView<Contract> {

    @Autowired
    private DialogWindows dialogWindows;
    @ViewComponent
    private EntityPicker<Counterparty> counterpartyField;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<Contract> event) {
        event.getEntity().setCounterpartyType(CounterpartyType.LEGAL_CP);
    }

    @Subscribe("counterpartyTypeField")
    public void onCounterpartyTypeFieldComponentValueChange(final AbstractField.ComponentValueChangeEvent<JmixSelect<CounterpartyType>, CounterpartyType> event) {
        if (event.isFromClient()) {
            getEditedEntity().setCounterparty(null);
        }
    }

    @Subscribe("counterpartyField.entityLookupAction")
    public void onCounterpartyFieldEntityLookupAction(final ActionPerformedEvent event) {
        switch (getEditedEntity().getCounterpartyType()) {
            case LEGAL_CP -> dialogWindows.lookup(this, LegalCP.class)
                    .withSelectHandler(selected ->
                            counterpartyField.setValue(selected.iterator().next()))
                    .open();
            case PHYSICAL_CP -> dialogWindows.lookup(this, PhysicalCP.class)
                    .withSelectHandler(selected ->
                            counterpartyField.setValue(selected.iterator().next()))
                    .open();
        }
    }
}