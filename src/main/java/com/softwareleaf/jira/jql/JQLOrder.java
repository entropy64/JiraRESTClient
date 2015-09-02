package com.softwareleaf.jira.jql;

/**
 * Provides an API for handling {@literal "ORDER BY"} JQL Keyword
 * grammar rules.
 *
 * @author Jonathon Hope
 */
public class JQLOrder {

    /**
     * This enum provides the types of JQL ordering.
     *
     * @author Jonathon Hope
     */
    public enum OrderType {
        /**
         * Ascending.
         */
        ASC,
        /**
         * Descending.
         */
        DESC

    }

    private JQL jql;

    public JQLOrder(JQL jql) {
        this.jql = jql;
    }

    private JQLKeyword addOrderType(String field) {
        jql.add(field);
        return new JQLKeyword(jql);
    }

    public JQLKeyword asc() {
        return addOrderType(" " + OrderType.ASC);
    }

    public JQLKeyword desc() {
        return addOrderType(" " + OrderType.DESC);
    }

}
