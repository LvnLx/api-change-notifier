package com.lvnlx.job.posting.notifier.model.netflix.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobsResponsePosition {
    public String id;
    public String name;
    public String canonicalPositionUrl;
}
