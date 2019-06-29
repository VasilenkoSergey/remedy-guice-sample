package io.vasilenko.remedy.guice.sample;

import com.bmc.arsys.api.Value;
import com.bmc.arsys.pluginsvr.plugins.ARFilterAPIPlugin;
import com.bmc.arsys.pluginsvr.plugins.ARPluginContext;
import com.bmc.thirdparty.org.slf4j.Logger;
import com.bmc.thirdparty.org.slf4j.LoggerFactory;
import com.google.inject.Guice;
import io.vasilenko.remedy.guice.sample.di.PluginModule;
import io.vasilenko.remedy.guice.sample.service.PluginService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GuiceSamplePlugin extends ARFilterAPIPlugin {

    private static final int INPUT_NAME_VALUE_INDEX = 0;

    private final Logger log = LoggerFactory.getLogger(GuiceSamplePlugin.class);

    @Inject
    private PluginService service;

    @Override
    public void initialize(ARPluginContext context) {
        Guice.createInjector(new PluginModule()).injectMembers(this);
        log.info("initialized");
    }

    @Override
    public List<Value> filterAPICall(ARPluginContext context, List<Value> inputValues) {
        String name = String.valueOf(inputValues.get(INPUT_NAME_VALUE_INDEX));
        log.info("name: {}", name);
        String greeting = service.greeting(name);
        log.info("greeting: {}", greeting);
        List<Value> outputList = new ArrayList<>();
        outputList.add(new Value(greeting));
        return outputList;
    }
}
