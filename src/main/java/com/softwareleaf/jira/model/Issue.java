package com.softwareleaf.jira.model;

import java.util.Objects;

/**
 * Represents a Jira Issue.
 *
 * @author Jonathon Hope
 * @since 19/06/2015
 */
public class Issue
{
    /**
     * The id of this Issue.
     */
    private String id;
    /**
     * The key of this Issue.
     */
    private String key;
    /**
     * The fields possessed by this Issue.
     */
    private Fields fields;

    /**
     * Constructor.
     */
    public Issue()
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

    public String getKey()
    {
        return key;
    }

    public void setKey( String key )
    {
        this.key = key;
    }

    public Fields getFields()
    {
        return fields;
    }

    public void setFields( Fields fields )
    {
        this.fields = fields;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || !( o instanceof Issue ) )
        {
            return false;
        }
        Issue issue = (Issue) o;
        return Objects.equals( id, issue.id ) &&
                Objects.equals( key, issue.key ) &&
                Objects.equals( fields, issue.fields );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( id, key, fields );
    }
}

