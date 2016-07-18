package org.jasonxiao.demo.model;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Jason on 4/30/16.
 */
public class Asset {

    private String id;
    @NotBlank
    private String name;

    public Asset() {
    }

    public Asset(String id, String name) {
        this.id = id;
        this.name = name;
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

}
