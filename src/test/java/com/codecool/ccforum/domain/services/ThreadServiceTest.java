package com.codecool.ccforum.domain.services;

import org.junit.Test;

public class ThreadServiceTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateThreadWithInvalidAuthorId() {
        ThreadService threadService = new ThreadService(new UserDaoTestImpl(), new ThreadDaoTestImpl());
        threadService.createNewThread(234, "My first Thread", "Lorem ipsum dolor sit amet unesence elite une ante...");
    }

}
