package com.softwareleaf.jira.jql;

/**
 * Provides a DSL for generating JQL.
 * <p>
 * Example Usage:
 * <pre>
 *     // The
 *     // project = 10190 AND fixVersion = 15648 ORDER BY priority DESC, key ASC
 *     JQL jql = JQL.builder()
 *              .project()
 *              .equal("10190")
 *              .and()
 *              .fixVersion()
 *              .equal("15648")
 *              .orderBy("priority")
 *              .desc()
 *              .orderBy("key")
 *              .asc()
 *              .andReturn();
 * </pre>
 *
 * @author Jonathon Hope
 * @since 19/06/2015
 */
public class JQL
{

    private StringBuilder sb;

    public JQL()
    {
        clear();
    }

    public StringBuilder sb()
    {
        return sb;
    }

    public void add( String string )
    {
        sb.append( string );
    }

    public void clear()
    {
        sb = new StringBuilder();
    }

    public String build()
    {
        return sb.toString();
    }

    public static JQLField builder()
    {
        return new JQLField( new JQL() );
    }

}
