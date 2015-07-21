package com.softwareleaf.jira.model;

/**
 * Represents the fields object that a JSON Issue response contains.
 * <p>
 * Note: At this point, we only care about two fields of the fields available.
 *
 * @author Jonathon Hope
 * @since 19/06/2015
 */
public class Fields
{

    /**
     * The project that the parent issue belongs to.
     */
    private Project project;
    /**
     * The fix versions for this Fields instance (ie. for the parent Issue).
     */
    private FixVersion[] fixVersions;

    /**
     * Constructor.
     */
    public Fields()
    {
    }

    // getters and setters.

    public FixVersion[] getFixVersions()
    {
        return fixVersions;
    }

    public void setFixVersions( FixVersion[] fixVersions )
    {
        this.fixVersions = fixVersions;
    }

    public Project getProject()
    {
        return project;
    }

    public void setProject( Project project )
    {
        this.project = project;
    }
}
