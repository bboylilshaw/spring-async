package org.jasonxiao.demo.model;

/**
 * Created by Jason on 4/30/16.
 */
public class Asset {
    private String id;
    private String name;
    private String workspaceId;

    public Asset() {
    }

    public Asset(String id, String name, String workspaceId) {
        this.id = id;
        this.name = name;
        this.workspaceId = workspaceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
    }
}
