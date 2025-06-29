package com.lvnlx.job.posting.notifier.model.netflix.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobsResponse {
    public List<JobsResponsePosition> positions;
    public int count;
}
