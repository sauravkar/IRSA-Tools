package com.irsatools;

import com.irsatools.entities.global.OriginalCorpus;
import com.irsatools.entities.global.base.Info;
import com.irsatools.repositories.DictionaryRepository;
import com.irsatools.repositories.OriginalCorpusRepository;
import com.irsatools.repositories.ParsedCorpusRepository;
import com.irsatools.repositories.ResearchRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration("/test-provider-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestJpaDataProvider {

    private static final int ORIGINAL_CORPUS_LIMIT = 10;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    // Managed repositories
    @Autowired
    private OriginalCorpusRepository originalCorpusRepository;
    @Autowired
    private ParsedCorpusRepository parsedCorpusRepository;
    @Autowired
    private DictionaryRepository dictionaryRepository;
    @Autowired
    private ResearchRepository researchRepository;

    // Simple count tests
    @Test
    public void testCount_OriginalCorpusRepository() {
        log.info("Testing OriginalCorpusRepository...");
        log.info(String.valueOf(parsedCorpusRepository.count()) + " entities was found");
    }

    @Test
    public void testCount_ParsedCorpusRepository() {
        log.info("Testing ParsedCorpusRepository...");
        log.info(String.valueOf(parsedCorpusRepository.count()) + " entities was found");
    }

    @Test
    public void testCount_DictionaryRepository() {
        log.info("Testing DictionaryRepository...");
        log.info(String.valueOf(dictionaryRepository.count()) + " entities was found");
    }

    @Test
    public void testCount_ResearchRepository() {
        log.info("Testing ResearchRepository...");
        log.info(String.valueOf(researchRepository.count()) + " entities was found");
    }

    // Complex tests
    @Test
    public void testWorkflow_OriginalCorpusRepository() {
        log.info("Testing OriginalCorpusRepository...");
        long originalCorpusSize = originalCorpusRepository.count();
        List<OriginalCorpus> newCorpusList = generateOriginalCorpusList();
        originalCorpusRepository.save(newCorpusList);
        List<OriginalCorpus> generatedCorpusList = originalCorpusRepository.findAll();
        assertEquals(ORIGINAL_CORPUS_LIMIT, generatedCorpusList.size() - originalCorpusSize);
        log.info("Show all OriginalCorpuses stored in DB");
        for (OriginalCorpus corpus : generatedCorpusList) {
            log.info(corpus.getCorpusInfo().getName() + " | " + corpus.getCorpusInfo().getComment() + " | " + corpus.getCorpusInfo().getDescription());
        }
        originalCorpusRepository.delete(newCorpusList);
        assertEquals(originalCorpusSize, originalCorpusRepository.count());
    }

    /**
     * Generate OriginalCorpus entities for test purpose
     *
     * @return List with generated OriginalCorpuses
     */
    private List<OriginalCorpus> generateOriginalCorpusList() {
        List<OriginalCorpus> newCorpusList = new ArrayList<OriginalCorpus>(ORIGINAL_CORPUS_LIMIT);
        for (int i = 0; i < ORIGINAL_CORPUS_LIMIT; i++) {
            OriginalCorpus corpus = new OriginalCorpus();
            Info corpusInfo = new Info("Test Name " + i, "Test Description " + i, "Test Comment " + i);
            corpus.setCorpusInfo(corpusInfo);
            newCorpusList.add(corpus);
        }
        return newCorpusList;
    }
}
