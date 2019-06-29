package io.vasilenko.remedy.guice.sample.service.impl;

import io.vasilenko.remedy.guice.sample.service.PluginService;

public class PluginServiceImpl implements PluginService {

    @Override
    public String greeting(String name) {
        return "Hello " + name;
    }
}
