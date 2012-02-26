/**
 * File: ParsedText
 * Author: Nikolay Semenov <ns.semenov@gmail.com>
 * Date: 24.02.12
 */
package com.irsatools.global.entities;

import com.irsatools.global.entities.base.UUIDBase;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.List;

/**
 * Store the parsed text data as a list of tokens
 */
@Entity
public class ParsedText extends UUIDBase {

    private List<WordToken> tokens;

    @OneToMany(mappedBy = "parsedText", orphanRemoval = true)
    @OrderBy("position ASC")
    public List<WordToken> getTokens() {
        return tokens;
    }

    public void setTokens(List<WordToken> tokens) {
        this.tokens = tokens;
    }
}
