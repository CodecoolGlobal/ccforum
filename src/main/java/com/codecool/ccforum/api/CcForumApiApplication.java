package com.codecool.ccforum.api;

import com.codecool.ccforum.api.threads.ThreadsApiService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class CcForumApiApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public CcForumApiApplication() {
        singletons.add(new ThreadsApiService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
