package com.genspark.RestfulPersonalDictionary.Controller;

import com.genspark.RestfulPersonalDictionary.Entity.Entry;
import com.genspark.RestfulPersonalDictionary.Service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DictionaryController {

    @Autowired
    private EntryService entryService;

    @GetMapping("/")
    public String home() {
        return "<HTML>" +
                "<H1>Welcome to my personal dictionary app!</H1>" +
                "<H3>To use, type these endpoints in the url:</H3>" +
                "<ul>" +
                "<li>/words [GET]</li>" +
                "<li>/word/{entryId} [GET]</li>" +
                "<li>/word/{word} [GET]</li>" +
                "<li>/addword + JSON object body [POST]</li>" +
                "<li>/updateword + JSON object body [PUT]</li>" +
                "<li>/deletebyid/{entryId} [DELETE]</li>" +
                "<li>/deletebyword/{word} [DELETE]</li>" +
                "<li>/addtestwords [POST]</li>" +
                "<li>/clearwords [DELETE]</li>" +
                "</ul>" +
                "</HTML>";
    }

    @GetMapping("/words")
    public List<Entry> getAllEntries() {
        return this.entryService.getAllEntries();
    }

    @GetMapping("/word/{entryId}")
    public Entry getEntryById(@PathVariable int entryId) {
        return this.entryService.getEntryById(entryId);
    }

    @GetMapping("/word/{word}")
    public List<Entry> getEntryByWord(@PathVariable String word) {
        return this.entryService.getEntryByWord(word);
    }

    @PostMapping("/addword")
    public Entry addEntry(@RequestBody Entry entry) {
        return this.entryService.addEntry(entry);
    }

    @PutMapping("/updateword")
    public Entry updateEntry(@RequestBody Entry entry) {
        return this.entryService.updateEntry(entry);
    }

    @DeleteMapping("/deletebyid/{entryId}")
    public String deleteEntryById(@PathVariable int entryId) {
        return this.entryService.deleteEntryById(entryId);
    }

    @DeleteMapping("/deletebyword/{word}")
    public String deleteEntryByWord(@PathVariable String word) {
        return this.entryService.deleteEntryByWord(word);
    }

    @PostMapping("/addtestwords")
    public String addTestEntries() {
        return this.entryService.addTestEntries();
    }

    @DeleteMapping("/clearwords")
    public String deleteAllEntries() {
        return this.entryService.deleteAllEntries();
    }
}
