/**
 * File: UUIDBase
 * Author: Nikolay Semenov <ns.semenov@gmail.com>
 * Date: 24.02.12
 */
package com.irsatools.entities.global.base;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

/**
 * Superclass for all global entities of IRSA-Tools project.
 */
@MappedSuperclass
public class UUIDBase implements Serializable {

    private static final long serialVersionUID = 176086968335400167L;

    private String id;

    /**
     * The 36 character length UUID String
     * @return the primary key
     */
    @Id
    @Column(length = 36)
    public String getId() {
        return id;
    }

    /**
     * It is not allowed to set this value more once
     * @param id the primary key
     */
    public void setId(String id) {
        if (StringUtils.isBlank(id) || id.equals(this.id)) {
            return; //EclipseLink Bugfix
        } else if (StringUtils.isBlank(this.id)) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("It is not allowed to change an existing id!");
        }
    }

    @PrePersist
    protected void onPersist(){
       if (StringUtils.isBlank(this.id)){
           this.id = UUID.randomUUID().toString();
       }
    }
}
