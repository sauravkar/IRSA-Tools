package com.irsatools.conversion;

import com.irsatools.entities.global.OriginalCorpus;
import com.irsatools.entities.global.OriginalText;
import com.irsatools.entities.global.base.Info;
import com.irsatools.repositories.OriginalCorpusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class XmlCollectionSAXHandler extends DefaultHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private OriginalCorpusRepository repository;

    private List<OriginalText> texts = new ArrayList<OriginalText>();
    private StringBuilder currentStr;

    private Info corpusInfo;

    public XmlCollectionSAXHandler(OriginalCorpusRepository repository) {
        this.repository = repository;
    }

    @Override
    public void startDocument() throws SAXException {
        corpusInfo = new Info();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentStr = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        final String value = currentStr.toString();

        if (qName.equals("text")) {
            texts.add(new OriginalText(value));
            if (texts.size() % 1000 == 0) {
                log.info("Processed " + texts.size() + " entities");
            }
        } else if (qName.equals("name")) {
            corpusInfo.setName(value);
        } else if (qName.equals("description")) {
            corpusInfo.setDescription(value);
        } else if (qName.equals("comment")) {
            corpusInfo.setComment(value);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentStr.append(new String(ch, start, length));
    }

    @Override
    public void endDocument() throws SAXException {
        OriginalCorpus corpus = new OriginalCorpus(corpusInfo, texts);
        repository.save(corpus);
    }
}
