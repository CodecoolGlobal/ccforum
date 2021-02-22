package com.codecool.ccforum.api.threads;

import com.codecool.ccforum.application.ServiceRegistry;
import com.codecool.ccforum.domain.entities.Thread;
import com.codecool.ccforum.domain.services.ThreadService;

import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collectors;

@Path("/threads")
@Consumes("application/json")
@Produces("application/json")
public class ThreadsApiService {

    @GET
    @Path("/list")
    @Consumes("application/json")
    @Produces("application/json")
    public ThreadListResponseDto list() {
        ThreadService ts = ServiceRegistry.getInstance(ThreadService.class);
        List<Thread> threads = ts.listThreads();
        List<ThreadListItemDto> itemDtos = threads.stream().map((t) -> {
            return new ThreadListItemDto(t.getId(), t.getTitle(), t.getDescription(), t.getAuthorId());
        }).collect(Collectors.toList());


        ThreadListResponseDto res = new ThreadListResponseDto();
        res.getThreads().addAll(itemDtos);

        return res;
    }

    @GET
    @Path("/{threadId}")
    public ThreadDto getThread(@PathParam("threadId") Long threadId) {
        ThreadService ts = ServiceRegistry.getInstance(ThreadService.class);
        Thread thread = ts.findById(threadId);

        return new ThreadDto(thread.getId(), thread.getTitle(), thread.getDescription(), thread.getAuthorId());
    }

    @POST
    @Path("/create")
    public CreateThreadResponseDto create(CreateThreadRequestDto req) {
        ThreadService ts = ServiceRegistry.getInstance(ThreadService.class);
        Thread thread = ts.createNewThread(1, req.getTitle(), req.getDesc());

        return new CreateThreadResponseDto(thread.getId());
    }

}
