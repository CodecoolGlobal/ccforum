package com.codecool.ccforum.api.threads;

public class CreateThreadResponseDto {

    private Long threadId;

    public CreateThreadResponseDto(Long threadId) {
        this.threadId = threadId;
    }

    public CreateThreadResponseDto() {
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }
}
