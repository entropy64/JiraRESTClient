package com.softwareleaf.jira.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * A set of static utility methods for Strings.
 *
 * @author Jonathon Hope
 * @since 19/06/2015
 */
public class StringUtility
{

    /**
     * Formats a date given as a string in a stringobject
     * allowed dates are
     * <p>
     * "yyyy/MM/dd HH:mm"
     * "yyyy-MM-dd HH:mm"
     * "yyyy/MM/dd"
     * "yyyy-MM-dd"
     *
     * @param date to convert
     * @return date object
     */
    public static Date stringToDate( String date ) throws ParseException
    {
        String pattern;
        if ( date.contains( "/" ) && date.contains( ":" ) )
        {
            pattern = "yyyy/MM/dd HH:mm";
        }
        else if ( date.contains( "/" ) && !date.contains( ":" ) )
        {
            pattern = "yyyy/MM/dd";
        }
        else if ( date.contains( "-" ) && date.contains( ":" ) )
        {
            pattern = "yyyy-MM-dd HH:mm";
        }
        else if ( date.contains( "-" ) && !date.contains( ":" ) )
        {
            pattern = "yyyy-MM-dd";
        }
        else
        {
            pattern = "dd.mm.yyyy";
        }

        return new SimpleDateFormat( pattern ).parse( date );
    }

    public static String dateToString( Date aDate )
    {
        return new SimpleDateFormat( "yyyy/MM/dd HH:mm" ).format( aDate );
    }

    public static void verifyParams( int minLength, Object... values )
    {
        if ( values.length < minLength )
        {
            throw new IllegalArgumentException( "Need at least " + minLength + " values" );
        }
    }

    /**
     * Converts a object into a string
     *
     * @param value object to convert
     * @return String value of object
     */
    public static String stringify( Object value )
    {
        if ( value == null )
        {
            return "";
        }
        else if ( value instanceof Boolean )
        {
            boolean b = (Boolean) value;
            return ( b ) ? "true" : "false";
        }
        else
        {
            if ( value instanceof Integer )
            {
                return "" + value;
            }
            else if ( value instanceof Double )
            {
                return "" + value;
            }
            else if ( value instanceof Long )
            {
                return "" + value;
            }
            else if ( value instanceof Float )
            {
                return "" + value;
            }
            else if ( value instanceof Enum )
            {
                return value.toString().toLowerCase();
            }
            else
            {
                return value.toString();
            }
        }
    }

    /**
     * creates a comma separated list out of objects in strings
     *
     * @param values array of objects
     * @return comma separated list
     */
    public static String commaSeparatedList( Object... values )
    {
        String toAdd = "";
        for ( int i = 0; i < values.length; i++ )
        {
            if ( i == values.length - 1 )
            {
                toAdd += stringify( values[i] );
            }
            else
            {
                toAdd += stringify( values[i] ) + ", ";
            }
        }
        return toAdd;
    }

    /**
     * creates a comma separated list out of objects in string
     *
     * @param values list of objects
     * @return comma separated list
     */
    public static String commaSeparatedList( List<Object> values )
    {
        return commaSeparatedList( values.toArray( new Object[values.size()] ) );
    }

    /**
     * almost the same list #commaSeparatedList but without comma
     *
     * @param values array of objects
     * @return list of separated items
     */
    public static String whiteSpaceSeparatedList( Object... values )
    {
        String toAdd = "";
        for ( int i = 0; i < values.length; i++ )
        {
            if ( i == values.length - 1 )
            {
                toAdd += stringify( values[i] );
            }
            else
            {
                toAdd += stringify( values[i] ) + " ";
            }
        }
        return toAdd;
    }

    /**
     * almost the same list #commaSeparatedList but without comma
     *
     * @param values list of objects
     * @return list of separated items
     */
    public static String whiteSpaceSeparatedList( List<Object> values )
    {
        return whiteSpaceSeparatedList( values.toArray( new Object[values.size()] ) );
    }

}
