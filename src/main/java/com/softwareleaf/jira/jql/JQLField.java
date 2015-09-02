package com.softwareleaf.jira.jql;

/**
 * @author Jonathon Hope
 */
public class JQLField {

    private JQL jql;

    public JQLField(JQL jql) {
        this.jql = jql;
    }

    private JQLOperator addField(String field) {
        jql.add(field);
        return new JQLOperator(jql);
    }


    public JQLOperator affectedVersion() {
        return addField("affectedVersion");
    }


    public JQLOperator assignee() {
        return addField("assignee");
    }


    public JQLOperator attachments() {
        return addField("attachments");
    }


    public JQLOperator category() {
        return addField("category");
    }


    public JQLOperator comment() {
        return addField("comment");
    }


    public JQLOperator component() {
        return addField("component");
    }


    public JQLOperator created() {
        return addField("created");
    }


    public JQLOperator createdDate() {
        return created();
    }


    public JQLOperator creator() {
        return addField("creator");
    }


    public JQLOperator customField(String fieldName) {
        return addField(fieldName);
    }


    public JQLOperator description() {
        return addField("description");
    }


    public JQLOperator due() {
        return addField("due");
    }


    public JQLOperator dueDate() {
        return addField("dueDate");
    }


    public JQLOperator environment() {
        return addField("environment");
    }


    public JQLOperator epicLink() {
        return addField("\"epic link\"");
    }


    public JQLOperator filter() {
        return addField("filter");
    }


    public JQLOperator fixVersion() {
        return addField("fixVersion");
    }


    public JQLOperator id() {
        return addField("id");
    }


    public JQLOperator issue() {
        return addField("issue");
    }


    public JQLOperator issueKey() {
        return addField("issueKey");
    }


    public JQLOperator issueType() {
        return addField("issueType");
    }


    public JQLOperator key() {
        return addField("key");
    }


    public JQLOperator lastViewed() {
        return addField("lastViewed");
    }


    public JQLOperator level() {
        return addField("level");
    }


    public JQLOperator originalEstimate() {
        return addField("originalEstimate");
    }


    public JQLOperator parent() {
        return addField("parent");
    }


    public JQLOperator priority() {
        return addField("priority");
    }


    public JQLOperator project() {
        return addField("project");
    }


    public JQLOperator remainingEstimate() {
        return addField("remainingEstimate");
    }


    public JQLOperator reporter() {
        return addField("reporter");
    }


    public JQLOperator request() {
        return addField("request");
    }


    public JQLOperator resolution() {
        return addField("resolution");
    }


    public JQLOperator resolutionDate() {
        return addField("resolutionDate");
    }


    public JQLOperator resolved() {
        return addField("resolved");
    }


    public JQLOperator savedFilter() {
        return addField("savedFilter");
    }


    public JQLOperator searchRequest() {
        return addField("searchRequest");
    }


    public JQLOperator sprint() {
        return addField("sprint");
    }


    public JQLOperator status() {
        return addField("status");
    }


    public JQLOperator summary() {
        return addField("summary");
    }


    public JQLOperator text() {
        return addField("text");
    }


    public JQLOperator timeEstimate() {
        return addField("timeEstimate");
    }


    public JQLOperator timeOriginalEstimate() {
        return addField("timeOriginalEstimate");
    }


    public JQLOperator type() {
        return addField("type");
    }


    public JQLOperator timeSpent() {
        return addField("timeSpent");
    }


    public JQLOperator updated() {
        return addField("updated");
    }


    public JQLOperator updatedDate() {
        return addField("updatedDate");
    }


    public JQLOperator voter() {
        return addField("voter");
    }


    public JQLOperator votes() {
        return addField("votes");
    }


    public JQLOperator watcher() {
        return addField("watcher");
    }


    public JQLOperator watchers() {
        return addField("watchers");
    }


    public JQLOperator workRatio() {
        return addField("workRatio");
    }

}
