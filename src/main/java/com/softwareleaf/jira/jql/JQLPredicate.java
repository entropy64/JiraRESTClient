package com.softwareleaf.jira.jql;

import com.softwareleaf.jira.util.StringUtility;

import java.util.Date;

/**
 * @author Jonathon Hope
 * @since 19/06/2015
 */
public class JQLPredicate
{

    private JQL myJql;

    public JQLPredicate( JQL aJQL )
    {
        this.myJql = aJQL;
    }

    private JQLPredicate addPredicate( String field )
    {
        myJql.add( field );
        return this;
    }

    private JQLField addPredicateToField( String field )
    {
        myJql.add( field );
        return new JQLField( myJql );
    }

    private JQLOrder addPredicateToOrder( String field )
    {
        myJql.add( field );
        return new JQLOrder( myJql );
    }


    public JQLPredicate after( String date )
    {
        return addPredicate( " after " + date );
    }


    public JQLPredicate after( Date aDate )
    {
        return after( StringUtility.dateToString( aDate ) );
    }


    public JQLPredicate before( String date )
    {
        return addPredicate( " before " + date );
    }


    public JQLPredicate before( Date date )
    {
        return after( StringUtility.dateToString( date ) );
    }


    public JQLPredicate by( String username )
    {
        return addPredicate( " BY " + username );
    }


    public JQLPredicate during( String date1, String date2 )
    {
        return addPredicate( " DURING (" + date1 + ", " + date2 + ")" );
    }


    public JQLPredicate during( Date date1, Date date2 )
    {
        return during( StringUtility.dateToString( date1 ), StringUtility.dateToString( date2 ) );
    }


    public JQLPredicate on( String date )
    {
        return addPredicate( " ON " + date );
    }


    public JQLPredicate on( Date aDate )
    {
        return on( StringUtility.dateToString( aDate ) );
    }


    public JQLPredicate from( Object value )
    {
        return addPredicate( " FROM " + StringUtility.stringify( value ) );
    }


    public JQLPredicate to( Object value )
    {
        return addPredicate( " TO " + StringUtility.stringify( value ) );
    }


    public JQLField and()
    {
        return addPredicateToField( " AND " );
    }


    public JQLField or()
    {
        return addPredicateToField( " OR " );
    }


    public JQLOrder orderBy( String... fieldNames )
    {
        return addPredicateToOrder( " order by " + StringUtility.commaSeparatedList( fieldNames ) );
    }


    public String build()
    {
        return myJql.build();
    }


    public JQL andReturn()
    {
        return myJql;
    }

}
