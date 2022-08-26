package com.genspark.RestfulPersonalDictionary.Service;


import com.genspark.RestfulPersonalDictionary.Entity.Entry;

import java.util.List;

public interface EntryService {

    List<Entry> getAllEntries();
    Entry getEntryById(int entryId);
    List<Entry> getEntryByWord(String word);
    Entry addEntry(Entry entry);
    Entry updateEntry(Entry entry);
    String deleteEntryById(int entryId);
    String deleteEntryByWord(String word);

    String addTestEntries();
    String deleteAllEntries();
}
