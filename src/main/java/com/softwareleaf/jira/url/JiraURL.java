package com.softwareleaf.jira.url;

import com.softwareleaf.jira.jql.JQL;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Can be used to build a URL.
 *
 * @author Jonathon Hope
 */
public class JiraURL {

    /**
     * Added to complete the URL, such that it meets the requirements of a JIRA search XML view
     *
     * @see <a href="https://confluence.atlassian.com/display/DOC/JIRA+Issues+Macro">JIRA Issues Macro</a>
     */
    public final String XML_JIRA_SEARCH = "/sr/jira.issueviews:searchrequest-xml/temp/SearchRequest.xml";

    /**
     * If a JQL object is provided, we must preface the
     */
    public final String ADD_JQL_QUERY = "?jqlQuery=";

    /**
     * The base url of the JIRA instance.
     */
    private String myBaseURL;

    /**
     * The JQL Query.
     */
    private JQL myJQL;

    /**
     * Constructor
     *
     * @param myBaseURL the base url of the JIRA instance.
     * @param myJQL     the jql query to be converted to a URL encoded query string.
     */
    public JiraURL(String myBaseURL, JQL myJQL) {
        this.myBaseURL = myBaseURL;
        this.myJQL = myJQL;
    }

    /**
     * Build a {@link URL} from this {@code JiraURL}.
     *
     * @return a UTF-8 encoded URL.
     * @throws MalformedURLException if this jira URL is malformed.
     */
    public URL toURL() throws MalformedURLException {
        String queryString = "";
        try {
            queryString = URLEncoder.encode(myJQL.build(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new URL(myBaseURL + XML_JIRA_SEARCH + ADD_JQL_QUERY + queryString);
    }

}
