package com.lvnlx.job.posting.notifier.client;

import com.lvnlx.job.posting.notifier.enumeration.Method;
import com.lvnlx.job.posting.notifier.model.netflix.NetflixJob;
import com.lvnlx.job.posting.notifier.model.netflix.response.JobsResponse;
import com.lvnlx.job.posting.notifier.service.HttpService;
import com.lvnlx.job.posting.notifier.service.NotificationService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NetflixClient extends Client<NetflixJob> {
    NetflixClient(HttpService httpService, NotificationService notificationService) {
        super("Netflix", httpService, notificationService);
    }

    @Override
    protected List<NetflixJob> getAllJobs() throws IOException, InterruptedException {
        return getAll(0, Integer.MAX_VALUE)
                .stream()
                .flatMap(response -> response.positions.stream())
                .filter(position -> position.name.contains("4") && !position.name.contains("Security") && !position.name.contains("Site Reliability") && !position.name.contains("UI") && !position.name.contains("Android") && !position.name.contains("iOS"))
                .map(NetflixJob::new)
                .toList();
    }

    private List<JobsResponse> getAll(int offset, int total) throws IOException, InterruptedException {
        if (offset > total) {
            return new ArrayList<>();
        }

        int PAGE_SIZE = 10;

        JobsResponse response = httpService.sendRequest(Method.GET, String.format("https://explore.jobs.netflix.net/api/apply/v2/jobs?start=%d&num=%d&Teams=Engineering&Work%%20Type=remote&Region=ucan&sort_by=relevance", offset, PAGE_SIZE), JobsResponse.class);
        List<JobsResponse> responses = getAll(offset + PAGE_SIZE, response.count);
        responses.add(response);

        return responses;
    }
}
