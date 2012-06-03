/**
 *  File: Dictionary
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 27.02.12
 */
package com.irsatools.entities.global;

import com.irsatools.entities.global.base.Info;
import com.irsatools.entities.global.base.UUIDBase;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * The dictionary: store all unique words for each ParsedCorpus
 */
@Entity
public class Dictionary extends UUIDBase {

    private List<DictionaryWord> words;
    private Info info;

    public Dictionary() {}

    public Dictionary(List<DictionaryWord> words) {
        this.words = words;
    }

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
