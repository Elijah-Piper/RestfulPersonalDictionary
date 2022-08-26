package com.genspark.RestfulPersonalDictionary.Service;

import com.genspark.RestfulPersonalDictionary.Dao.EntryDao;
import com.genspark.RestfulPersonalDictionary.Entity.Entry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryDao entryDao;

    @Override
    public List<Entry> getAllEntries() {
        return this.entryDao.findAll();
    }

    @Override
    public Entry getEntryById(int entryId) {
        Optional<Entry> e = this.entryDao.findById(entryId);
        Entry entry = null;
        if (e.isPresent()) {
            entry = e.get();
        } else {
            throw new RuntimeException("Entry not found for id :: " + entryId);
        }

        return entry;
    }

    @Override
    public List<Entry> getEntryByWord(String word) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Query q = session.createQuery("from Entry where word=:w");
        q.setParameter("word", word);

        List<Entry> list = q.list();

        session.close();

        return list;
    }

    @Override
    public Entry addEntry(Entry entry) {
        return this.entryDao.save(entry);
    }

    @Override
    public Entry updateEntry(Entry entry) {
        return this.entryDao.save(entry);
    }

    @Override
    public String deleteEntryById(int entryId) {
        this.entryDao.deleteById(entryId);
        return "Successfully Deleted";
    }

    @Override
    public String deleteEntryByWord(String word) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Query q = session.createQuery("from Entry where word=:w");
        q.setParameter("w", word);

        List<Entry> list = q.list();
        Entry e = null;
        for (int i = 0; i < list.size(); i++) {
            e = list.get(i);
            this.entryDao.delete(e);
        }

        tx.commit();
        session.close();

        return "Entries Successfully Deleted";
    }

    @Override
    public String addTestEntries() {
        Entry e1 = new Entry("program", "prō-ˌgram", "programs", "noun", "a sequence of coded instructions that can be inserted into a mechanism (such as a computer)", "plan, instructions");
        Entry e2 = new Entry("java", "ja-və", "javas", "noun", "arabica coffee beans of plants grown in Java, Indonesia that produce a usually full-bodied coffee of low to medium acidity", "coffee, brew, caffeine");
        Entry e3 = new Entry("programmer", "prō-ˌgra-mər", "programmers", "noun", "a person who prepares and tests programs for devices (such as computers)", "coder, software engineer, hacker");

        this.entryDao.save(e1);
        this.entryDao.save(e2);
        this.entryDao.save(e3);

        return "Test Entries Successfully Added";
    }

    @Override
    public String deleteAllEntries() {
        this.entryDao.deleteAll();

        return "All Entries Successfully Deleted";
    }
}
