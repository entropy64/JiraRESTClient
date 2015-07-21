package com.softwareleaf.jira.jql;

import com.softwareleaf.jira.util.StringUtility;

/**
 * @author Jonathon Hope
 * @since 19/06/2015
 */
public class JQLOperator
{

    private JQL jql;

    public JQLOperator( JQL aJQL )
    {
        jql = aJQL;
    }

    private JQLKeyword addOperatorToKeyword( String field )
    {
        jql.add( field );
        return new JQLKeyword( jql );
    }

    private JQLValue addOperatorToValue( String field )
    {
        jql.add( field );
        return new JQLValue( jql );
    }

    private JQLPredicate addOperatorToPredicate( String field )
    {
        jql.add( field );
        return new JQLPredicate( jql );
    }

    private JQLOperator addOperator( String field )
    {
        jql.add( field );
        return this;
    }


    public JQLKeyword equal( Object value )
    {
        return addOperatorToKeyword( " = " + StringUtility.stringify( value ) );
    }


    public JQLKeyword notEquals( Object value )
    {
        return addOperatorToKeyword( " != " + StringUtility.stringify( value ) );
    }


    public JQLKeyword greaterThan( Object value )
    {
        return addOperatorToKeyword( " > " + StringUtility.stringify( value ) );
    }


    public JQLKeyword greaterThanEquals( Object value )
    {
        return addOperatorToKeyword( " >= " + StringUtility.stringify( value ) );
    }


    public JQLKeyword lessThan( Object value )
    {
        return addOperatorToKeyword( " < " + StringUtility.stringify( value ) );
    }


    public JQLKeyword lessThanEquals( Object value )
    {
        return addOperatorToKeyword( " <= " + StringUtility.stringify( value ) );
    }


    public JQLKeyword in( Object... values )
    {
        StringUtility.verifyParams( 2, values );
        return addOperatorToKeyword( " in (" + StringUtility.commaSeparatedList( values ) + ")" );
    }


    public JQLKeyword notIn( Object... values )
    {
        StringUtility.verifyParams( 2, values );
        return addOperatorToKeyword( " not in (" + StringUtility.commaSeparatedList( values ) + ")" );
    }


    public JQLKeyword contains( String value )
    {
        return addOperatorToKeyword( " ~ \"" + value + "\"" );
    }


    public JQLKeyword doesNotContain( String value )
    {
        return addOperatorToKeyword( " !~ \"" + value + "\"" );
    }


    public JQLValue is()
    {
        return addOperatorToValue( " is" );
    }


    public JQLValue isNot()
    {
        return addOperatorToValue( " is not" );
    }


    public JQLPredicate was( Object value )
    {
        return addOperatorToPredicate( " was " + StringUtility.stringify( value ) );
    }


    public JQLPredicate wasIn( Object... values )
    {
        StringUtility.verifyParams( 2, values );
        return addOperatorToPredicate( " was in (" + StringUtility.commaSeparatedList( values ) + ")" );
    }


    public JQLPredicate wasNotIn( Object... values )
    {
        StringUtility.verifyParams( 2, values );
        return addOperatorToPredicate( " was not in (" + StringUtility.commaSeparatedList( values ) + ")" );
    }


    public JQLPredicate wasNot( Object value )
    {
        return addOperatorToPredicate( " was not " + StringUtility.stringify( value ) );
    }


    public JQLPredicate changed()
    {
        return addOperatorToPredicate( " CHANGED" );
    }


    public JQLOperator not()
    {
        return addOperator( " not" );
    }

}
