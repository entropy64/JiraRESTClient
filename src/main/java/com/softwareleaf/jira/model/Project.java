package com.softwareleaf.jira.model;

import java.util.Objects;

/**
 * Represents the project object that is nested within the JSON representation of
 * a Jira Issue.
 * <p/>
 * <pre>{@literal
 *       "project": {
 *              "self": "http://qvjira101/rest/api/2/project/10190",
 *              "id": "10190",
 *              "key": "SP",
 *              "name": "Service Portal",
 *              "avatarUrls": {
 *                  "48x48": "http://qvjira101/secure/projectavatar?pid=10190&avatarId=12010",
 *                  ...
 *              }
 *       },
 * }
 * </pre>
 *
 * @author Jonathon Hope
 */
public class Project {

    /**
     * A url for the rest api endpoint for requesting this project object.
     */
    private String self;
    /**
     * The id of this project.
     */
    private String id;
    /**
     * The project key.
     */
    private String key;
    /**
     * The name of this project.
     */
    private String name;

    /**
     * Constructor.
     */
    public Project() {
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project project = (Project) o;
        return Objects.equals(self, project.self) &&
                Objects.equals(id, project.id) &&
                Objects.equals(key, project.key) &&
                Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(self, id, key, name);
    }

}
