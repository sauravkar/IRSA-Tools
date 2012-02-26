/**
 * File: OriginalCorpus
 * Author: Nikolay Semenov <ns.semenov@gmail.com>
 * Date: 24.02.12
 */
package com.irsatools.global.entities;

import com.irsatools.global.entities.base.Info;
import com.irsatools.global.entities.base.UUIDBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the original text collection (corpus)
 */
@Entity
public class OriginalCorpus extends UUIDBase {

    private Info corpusInfo;
    private List<OriginalText> originalTexts;
    private List<ParsedCorpus> preparedCorpuses;

    @Embedded
    public Info getCorpusInfo() {
        return corpusInfo;
    }

    public void setCorpusInfo(Info corpusInfo) {
        this.corpusInfo = corpusInfo;
    }

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "ORIGINAL_CORPUS", nullable = false)
    public List<OriginalText> getOriginalTexts() {
        if (originalTexts == null) {
            originalTexts = new ArrayList<OriginalText>();
        }
        return originalTexts;
    }

    public void setOriginalTexts(List<OriginalText> originalTexts) {
        this.originalTexts = originalTexts;
    }

    @OneToMany(mappedBy = "parentCorpus")
    @JoinColumn(name = "ORIGINAL_CORPUS")
    public List<ParsedCorpus> getPreparedCorpuses() {
        if (preparedCorpuses == null) {
            preparedCorpuses = new ArrayList<ParsedCorpus>();
        }
        return preparedCorpuses;
    }

    public void setPreparedCorpuses(List<ParsedCorpus> preparedCorpuses) {
        this.preparedCorpuses = preparedCorpuses;
    }
}
