package com.softwareleaf.jira.jql;

import com.softwareleaf.jira.util.StringUtility;

/**
 * There are currently two {@code ValueTypes} that can be used with {@code JQLPredicate}:
 * {@code NULL} and {@code EMPTY}.
 * <p/>
 * See the following:
 * <ul>
 * <li><a href="https://confluence.atlassian.com/jira/advanced-searching-179442050.html#AdvancedSearching-KeywordsReference-EMPTY">EMPTY Documentation</a></li>
 * <li><a href="https://confluence.atlassian.com/jira/advanced-searching-179442050.html#AdvancedSearching-NULL">NULL Documentation</a></li>
 * </ul>
 *
 * @author Jonathon Hope
 */
public class JQLValue {

    public enum ValueType {
        NULL,
        EMPTY
    }

    private JQL jql;

    public JQLValue(JQL aJQL) {
        jql = aJQL;
    }

    private JQLPredicate addValueToPredicate(String field) {
        jql.add(field);
        return new JQLPredicate(jql);
    }

    public JQLPredicate empty() {
        return addValueToPredicate(" " + StringUtility.stringify(ValueType.EMPTY));
    }

    public JQLPredicate nul() {
        return addValueToPredicate(" " + StringUtility.stringify(ValueType.NULL));
    }

}
