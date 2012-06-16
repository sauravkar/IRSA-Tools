package com.irsatools;

import com.irsatools.conversion.SimpleCorpusParser;
import com.irsatools.conversion.XmlCollectionSAXHandler;
import com.irsatools.entities.global.OriginalCorpus;
import com.irsatools.entities.global.OriginalText;
import com.irsatools.repositories.DictionaryRepository;
import com.irsatools.repositories.OriginalCorpusRepository;
import com.irsatools.repositories.ParsedCorpusRepository;
import com.irsatools.repositories.ResearchRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("/test-provider-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class XmlCollectionImporter {

    private static Logger log = LoggerFactory.getLogger(XmlCollectionImporter.class);

    // Managed repositories
    @Autowired
    private OriginalCorpusRepository originalCorpusRepository;
    @Autowired
    private ParsedCorpusRepository parsedCorpusRepository;
    @Autowired
    private DictionaryRepository dictionaryRepository;
    @Autowired
    private ResearchRepository researchRepository;

    public void testImportFile() {
        String filename = "/mnt/main/share/virtual/nyt/nytimes2005.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxParserFactory.newSAXParser();
            XmlCollectionSAXHandler handler = new XmlCollectionSAXHandler(originalCorpusRepository);

            parser.parse(new File(filename), handler);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public void cleanDB() {
        // TODO: make it work
        originalCorpusRepository.deleteAll();
        /*List<OriginalCorpus> all = originalCorpusRepository.findAll();
        OriginalCorpus originalCorpus = all.get(0);
        List<OriginalText> originalTexts = originalCorpus.getOriginalTexts();*/
    }

    @Test
    public void parseCorpus() {
        List<OriginalCorpus> corpuses = originalCorpusRepository.findAll();
        for (OriginalCorpus corpus : corpuses) {
            new SimpleCorpusParser().parseCorpus(corpus);
        }
    }

    @Test
    public void testTest() {
        List<OriginalCorpus> all = originalCorpusRepository.findAll();
        for (OriginalCorpus originalCorpus : all) {
            List<OriginalText> originalTexts = originalCorpus.getOriginalTexts();
            for (OriginalText originalText : originalTexts) {
                System.out.println(originalText.getData().length());
            }
        }
    }
}
