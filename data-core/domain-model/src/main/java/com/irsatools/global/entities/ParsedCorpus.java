/**
 *  File: ParsedCorpus
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 24.02.12
 */
package com.irsatools.global.entities;

import com.irsatools.global.entities.base.Info;
import com.irsatools.global.entities.base.UUIDBase;

import javax.persistence.*;
import java.util.List;

/**
 * Represents the parsed text collection (corpus)
 */
@Entity
public class ParsedCorpus extends UUIDBase{

    private Info info;
    private OriginalCorpus parentCorpus;
    private List<ParsedText> parsedTexts;
    private Dictionary dictionary;

    @Embedded
    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @ManyToOne
    public OriginalCorpus getParentCorpus() {
        return parentCorpus;
    }

    public void setParentCorpus(OriginalCorpus parentCorpus) {
        this.parentCorpus = parentCorpus;
    }

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "PARSED_CORPUS", nullable = false)
    public List<ParsedText> getParsedTexts() {
        return parsedTexts;
    }

    public void setParsedTexts(List<ParsedText> parsedTexts) {
        this.parsedTexts = parsedTexts;
    }

    @OneToOne(orphanRemoval = true)
    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
}
