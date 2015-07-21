package com.softwareleaf.jira.model;

/**
 * <pre>{@literal
 *     "fixVersions": [{
 *          "self":"http://qvjira101/rest/api/2/version/15648",
 *          "id":"15648",
 *          "name":"SP 2015.R.1",
 *          "archived":false,
 *          "released":true,
 *          "releaseDate":"2015-03-15"
 *      }]
 * }</pre>
 *
 * @author Jonathon Hope
 * @since 19/06/2015
 */
public class FixVersion
{

    /**
     * The identifier of this FixVersion.
     */
    private String id;
    /**
     * The name of this FixVersion
     */
    private String name;
    /**
     * The url of this FixVersion (REST URL).
     */
    private String self;

    /**
     * Default Constructor.
     */
    public FixVersion()
    {
    }

    // getters and setters

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getSelf()
    {
        return self;
    }

    public void setSelf( String self )
    {
        this.self = self;
    }
}
