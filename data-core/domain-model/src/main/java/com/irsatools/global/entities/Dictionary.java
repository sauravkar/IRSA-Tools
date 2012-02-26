/**
 *  File: Dictionary
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 27.02.12
 */
package com.irsatools.global.entities;

import com.irsatools.global.entities.base.Info;
import com.irsatools.global.entities.base.UUIDBase;

import javax.persistence.*;
import java.util.List;

/**
 * The dictionary: store all unique words for each ParsedCorpus
 */
@Entity
public class Dictionary extends UUIDBase {

    private List<DictionaryWord> words;
    private Info info;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "DICTIONARY", nullable = false)
    public List<DictionaryWord> getWords() {
        return words;
    }

    public void setWords(List<DictionaryWord> words) {
        this.words = words;
    }

    @Embedded
    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
