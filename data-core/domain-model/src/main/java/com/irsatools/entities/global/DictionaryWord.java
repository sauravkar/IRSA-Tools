/**
 *  File: DictionaryWord
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 26.02.12
 */
package com.irsatools.entities.global;

import com.irsatools.entities.global.base.UUIDBase;

import javax.persistence.Entity;

/**
 * Represents the word stored in dictionary
 */
@Entity
public class DictionaryWord extends UUIDBase {

    private String word;
    private String stem;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }
}
