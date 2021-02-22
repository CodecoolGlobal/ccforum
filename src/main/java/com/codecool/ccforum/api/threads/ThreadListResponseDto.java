package com.codecool.ccforum.api.threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadListResponseDto {

    private List<ThreadListItemDto> threads = new ArrayList<>();

    public List<ThreadListItemDto> getThreads() {
        return threads;
    }
}
