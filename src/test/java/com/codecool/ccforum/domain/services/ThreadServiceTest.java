package com.codecool.ccforum.domain.services;

import com.codecool.ccforum.persistence.ThreadDaoImpl;
import com.codecool.ccforum.persistence.UserDaoImpl;
import org.junit.Test;

public class ThreadServiceTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateThreadWithInvalidAuthorId() {
        ThreadService threadService = new ThreadService(new UserDaoImpl(), new ThreadDaoImpl());
        threadService.createNewThread(234, "My first Thread", "Lorem ipsum dolor sit amet unesence elite une ante...");
    }

}
