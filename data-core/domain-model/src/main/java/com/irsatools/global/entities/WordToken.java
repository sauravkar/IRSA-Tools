/**
 *  File: WordToken
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 26.02.12
 */
package com.irsatools.global.entities;

import com.irsatools.global.entities.base.UUIDBase;
import com.irsatools.global.entities.enums.SentenceMark;
import com.irsatools.global.entities.enums.WordCase;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Represents the token: particular word in the text.<br/>
 * Each token includes:
 * <ul>
 *     <li><i>dictionaryWord</i>: word  from assigned dictionary</li>
 *     <li><i>position</i>: word's position in the text</li>
 *     <li><i>wordCase</i>: word starts with uppercase / lowercase letter</li>
 *     <li><i>punctuation</i>: punctuation mark (the string which follows current word)</li>
 *     <li><i>sentenceMark</i>: the word's position in sentence (first, middle or last)</li>
 * </ul>
 */
@Entity
public class WordToken extends UUIDBase{
    
    private DictionaryWord word;
    private Integer position;
    private WordCase wordCase;
    private String punctuation;
    private SentenceMark sentenceMark;
    private ParsedText parsedText;

    @OneToOne
    public DictionaryWord getWord() {
        return word;
    }

    public void setWord(DictionaryWord word) {
        this.word = word;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Enumerated
    public WordCase getWordCase() {
        return wordCase;
    }

    public void setWordCase(WordCase wordCase) {
        this.wordCase = wordCase;
    }

    public String getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    @Enumerated
    public SentenceMark getSentenceMark() {
        return sentenceMark;
    }

    public void setSentenceMark(SentenceMark sentenceMark) {
        this.sentenceMark = sentenceMark;
    }

    @ManyToOne
    public ParsedText getParsedText() {
        return parsedText;
    }

    public void setParsedText(ParsedText parsedText) {
        this.parsedText = parsedText;
    }
}
