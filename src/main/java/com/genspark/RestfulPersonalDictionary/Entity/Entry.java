package com.genspark.RestfulPersonalDictionary.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Entry {

    @Id
    @Column(name="entryId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int entryId;
    private String word;
    private String pronunciation;
    private String pluralForm;
    private String partOfSpeech;
    private String definition;
    private String synonyms;

    public Entry(int entryId, String word, String pronunciation, String pluralForm, String partOfSpeech, String definition, String synonyms) {
        this.entryId = entryId;
        this.word = word;
        this.pronunciation = pronunciation;
        this.pluralForm = pluralForm;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
        this.synonyms = synonyms;
    }

    public Entry(String word, String pronunciation, String pluralForm, String partOfSpeech, String definition, String synonyms) {
        this.word = word;
        this.pronunciation = pronunciation;
        this.pluralForm = pluralForm;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
        this.synonyms = synonyms;
    }

    public Entry() {
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getPluralForm() {
        return pluralForm;
    }

    public void setPluralForm(String pluralForm) {
        this.pluralForm = pluralForm;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String synonyms) {
        this.synonyms = synonyms;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "entryId=" + entryId +
                ", word='" + word + '\'' +
                ", pronunciation='" + pronunciation + '\'' +
                ", pluralForm='" + pluralForm + '\'' +
                ", partOfSpeech='" + partOfSpeech + '\'' +
                ", definition='" + definition + '\'' +
                ", synonyms=" + synonyms +
                '}';
    }
}
