package com.softwareleaf.jira.jql;

/**
 * @author Jonathon Hope
 * @since 19/06/2015
 */
public class JQLOrder
{

    /**
     * This enum provides the types of JQL ordering.
     *
     * @author Jonathon Hope
     * @since 19/06/2015
     */
    public enum OrderType
    {
        /**
         * Ascending.
         */
        ASC,
        /**
         * Descending.
         */
        DESC

    }

    private JQL myJql;

    public JQLOrder( JQL jql )
    {
        this.myJql = jql;
    }

    private JQLKeyword addOrderType( String field )
    {
        myJql.add( field );
        return new JQLKeyword( myJql );
    }

    public JQLKeyword asc()
    {
        return addOrderType( " " + OrderType.ASC );
    }

    public JQLKeyword desc()
    {
        return addOrderType( " " + OrderType.DESC );
    }

}
