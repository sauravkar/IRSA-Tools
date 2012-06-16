package com.irsatools.conversion;

import com.irsatools.entities.global.OriginalCorpus;
import com.irsatools.entities.global.ParsedCorpus;

/**
 * Created by IntelliJ IDEA.
 * Author: Medyanikov Vasily (vasily.medyanikov@gmail.com)
 * Date: 6/16/12
 * Time: 12:14 PM
 */
public interface CorpusParser {
    ParsedCorpus parseCorpus(OriginalCorpus originalCorpus);
}
