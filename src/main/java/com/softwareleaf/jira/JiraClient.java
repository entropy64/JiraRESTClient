package com.softwareleaf.jira;

import com.google.gson.GsonBuilder;
import com.softwareleaf.jira.model.Issue;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import java.util.Base64;

/**
 * Provides a wrapper around the JiraAPI.
 *
 * @author Jonathon Hope
 * @since 19/06/2015
 */
public class JiraClient
{
    /**
     * The default base url is the production confluence instance.
     */
    public static final String THE_BASE_URL = "http://qvjira101";
    // Burp Extension Utility account credentials
    private static final String DEFAULT_USERNAME = "burp";
    private static final String DEFAULT_PASSWORD = "Q@e4T^u8O)[=";

    /**
     * The JiraAPI endpoint.
     */
    private JiraAPI myJiraAPI;

    /**
     * Constructor.
     *
     * @param builder the factory used to build this JiraClient.
     */
    protected JiraClient( Builder builder )
    {
        this.myJiraAPI = builder.myJiraAPI;
    }

    /**
     * @param id the identifier or key for a JIRA issue.
     * @return a JIRA Issue model instance.
     * @see JiraAPI#getIssueById(String)
     */
    public Issue getIssue( String id )
    {
        return myJiraAPI.getIssueById( id );
    }

    /**
     * Factory object for chaining the construction of a {@code ConfluenceClient}.
     *
     * @return an instance of the internal Builder class.
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * A Builder factory for implementing the Builder Pattern.
     */
    public static class Builder
    {
        /**
         * This is the reference to the concrete REST API Client generated by Retrofit.
         */
        private JiraAPI myJiraAPI;
        /**
         * The username forms the first part of the credential used to authenticate requests.
         */
        private String myUsername;
        /**
         * The password forms the second part of the credential used to authenticate requests.
         */
        private String myPassword;
        /**
         * By default, {@link #THE_BASE_URL} will be used as the url of the confluence instance; when
         * this is set, requests will be made to this base URL instead.
         */
        private String myAlternativeBaseURL;

        // prevent direct instantiation by external classes.
        private Builder()
        {
        }

        /**
         * Set the username parameter.
         *
         * @param username the username.
         * @return {@code this}.
         */
        public Builder username( String username )
        {
            this.myUsername = username;
            return this;
        }

        /**
         * Sets the password parameter.
         *
         * @param password the password matching the username.
         * @return {@code this}.
         */
        public Builder password( String password )
        {
            this.myPassword = password;
            return this;
        }

        /**
         * By default, {@link #THE_BASE_URL BaseURL} will be used as the url of the confluence instance; when
         * this is set, requests will be made to this base URL instead.
         *
         * @param url the alternative Base url of the confluence instance to make requests to.
         * @return {@code this}.
         */
        public Builder baseURL( String url )
        {
            this.myAlternativeBaseURL = url;
            return this;
        }

        /**
         * Build and return a configured JiraClient instance.
         *
         * @return a configured {@code JiraClient} instance.
         */
        public JiraClient build()
        {
            // determine if we are using the production confluence or not.
            final String URL = myAlternativeBaseURL == null ? THE_BASE_URL : myAlternativeBaseURL;
            // determine the user credentials to use.
            String username = myUsername == null ? DEFAULT_USERNAME : myUsername;
            String password = myPassword == null ? DEFAULT_PASSWORD : myPassword;
            /*
             * The Confluence REST API requires HTTP Basic authentication using a
             * username and password pair, for a given Confluence user.
             * We therefore need to first encode the credentials using a Base64 encoder
             * and set up an interceptor that adds the requisite HTTP headers to each request.
             */
            final String credentials = username + ":" + password;
            // encode in base64.
            final String encodedCredentials = "Basic " + Base64.getEncoder().encodeToString( credentials.getBytes() );

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint( URL )
                    .setConverter( new GsonConverter( new GsonBuilder().disableHtmlEscaping().create() ) )
                    .setLogLevel( RestAdapter.LogLevel.FULL )
                    .setLog( System.out::println )
                    .setRequestInterceptor(
                            request -> {
                                request.addHeader( "Accept", "application/json" );
                                request.addHeader( "Authorization", encodedCredentials );
                            }
                    )
                    .build();

            // Create an implementation of the API defined by the specified JiraAPI interface
            this.myJiraAPI = restAdapter.create( JiraAPI.class );

            return new JiraClient( this );
        }

    }

}
