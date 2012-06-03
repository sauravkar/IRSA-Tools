package com.irsatools.conversion;

import com.irsatools.entities.global.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: Medyanikov Vasily (vasily.medyanikov@gmail.com)
 * Date: 6/3/12
 * Time: 1:21 AM
 */
public class SimpleTextParser {
    public ParsedCorpus parseCorpus(OriginalCorpus originalCorpus) {
        // we want those
        List<DictionaryWord> words = new ArrayList<DictionaryWord>();
        List<ParsedText> parsedTexts = new ArrayList<ParsedText>();

        Map<String, DictionaryWord> wordMapping = new HashMap<String, DictionaryWord>();
        for (OriginalText originalText : originalCorpus.getOriginalTexts()) {
            List<WordToken> textTokens = new ArrayList<WordToken>();

            String text = originalText.getData().replaceAll("[\"]", " ");
            String[] tokens = text.split("\\s");
            for (int i = 0; i < tokens.length; i++) {
                textTokens.add(parseToken(tokens[i], wordMapping));
            }

            parsedTexts.add(new ParsedText(textTokens));
        }

        Dictionary dictionary = new Dictionary(words);
        ParsedCorpus parsedCorpus = new ParsedCorpus();
        parsedCorpus.setDictionary(dictionary);
        parsedCorpus.setInfo(originalCorpus.getCorpusInfo());
        parsedCorpus.setParentCorpus(originalCorpus);
        parsedCorpus.setParsedTexts(parsedTexts);

        return parsedCorpus;
    }

    private WordToken parseToken(String token, Map<String, DictionaryWord> wordMapping) {
        throw new NotImplementedException();
    }
}
