/**
 * File: Info
 * Author: Nikolay Semenov <ns.semenov@gmail.com>
 * Date: 24.02.12
 */
package com.irsatools.entities.global.base;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Base embeddable class for object's info.<br/>
 * Info includes:
 * <ul>
 *  <li>Name</li>
 *  <li>Description</li>
 *  <li>Comment</li>
 * </ul>
 */
@Embeddable
public class Info {
    private String name;
    private String description;
    private String comment;

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Info() {
    }

    public Info(String name, String description, String comment) {
        this.name = name;
        this.description = description;
        this.comment = comment;
    }
}
