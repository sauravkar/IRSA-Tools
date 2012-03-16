/**
 * File: OriginalText
 * Author: Nikolay Semenov <ns.semenov@gmail.com>
 * Date: 24.02.12
 */
package com.irsatools.entities.global;

import com.irsatools.entities.global.base.UUIDBase;

import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * Store the original text data in <b>XML format</b>
 * <br/>
 * Important: should be XML valid
 */
@Entity
public class OriginalText extends UUIDBase {

    private String data;

    @Lob
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
