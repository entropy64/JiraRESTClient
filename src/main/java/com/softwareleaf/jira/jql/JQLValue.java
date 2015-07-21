package com.softwareleaf.jira.jql;

import com.softwareleaf.jira.util.StringUtility;

/**
 * @author Jonathon Hope
 * @since 19/06/2015
 */
public class JQLValue
{
    public enum ValueType
    {
        NULL,
        EMPTY
    }

    private JQL myJql;

    public JQLValue( JQL aJQL )
    {
        myJql = aJQL;
    }

    private JQLPredicate addValueToPredicate( String field )
    {
        myJql.add( field );
        return new JQLPredicate( myJql );
    }

    public JQLPredicate empty()
    {
        return addValueToPredicate( " " + StringUtility.stringify( ValueType.EMPTY ) );
    }

    public JQLPredicate nul()
    {
        return addValueToPredicate( " " + StringUtility.stringify( ValueType.NULL ) );
    }

}
