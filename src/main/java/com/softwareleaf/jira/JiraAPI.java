package com.softwareleaf.jira;

import com.softwareleaf.jira.model.Issue;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Specifies the REST API endpoints and requests supported by this Jira Client.
 *
 * @author Jonathon Hope
 * @see <a href="https://docs.atlassian.com/jira/REST/latest/">JIRA REST API DOCS</a>
 */
public interface JiraAPI {

    /**
     * GET an Issue by Id or Key. Returns a full representation of the issue for the
     * given issue key.
     *
     * @param id the id of the issue fetch.
     * @return the Content instance representing the JSON response.
     * @see <a href="https://docs.atlassian.com/jira/REST/latest/#api/2/issue-getIssue">
     * Get Issue Documentation</a>
     */
    @GET("/rest/api/2/issue/{id}")
    Issue getIssueById(@Path("id") String id);

}
