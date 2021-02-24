package com.codecool.ccforum.application;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Inj {

    private static Injector injector = null;

    public static <T> T getInstance(Class<T> clazz) {
        if (injector == null) {
            injector = Guice.createInjector(new CcForumModule());
        }
        return injector.getInstance(clazz);
    }

    private Inj() {
    }
}
