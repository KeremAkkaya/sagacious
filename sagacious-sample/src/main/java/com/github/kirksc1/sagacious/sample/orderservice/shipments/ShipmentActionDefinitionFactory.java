package com.github.kirksc1.sagacious.sample.orderservice.shipments;

import com.github.kirksc1.sagacious.CompensatingActionDefinition;
import com.github.kirksc1.sagacious.action.CompensatingActionDefinitionFactory;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShipmentActionDefinitionFactory implements CompensatingActionDefinitionFactory<String> {

    @NonNull
    private Environment environment;

    @Override
    public CompensatingActionDefinition buildDefinition(String guid) {
        CompensatingActionDefinition retVal = new CompensatingActionDefinition();
        retVal.setUri("http://localhost:" + environment.getProperty("local.server.port") + "/shipping-service/shipments/" + guid);
        return retVal;
    }
}
