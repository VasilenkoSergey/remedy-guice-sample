package io.vasilenko.remedy.guice.sample.di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.vasilenko.remedy.guice.sample.service.PluginService;
import io.vasilenko.remedy.guice.sample.service.impl.PluginServiceImpl;

public class PluginModule extends AbstractModule {

    @Provides
    @Singleton
    PluginService providePluginService() {
        return new PluginServiceImpl();
    }
}
