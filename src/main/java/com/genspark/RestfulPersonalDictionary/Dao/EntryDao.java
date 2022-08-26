package com.genspark.RestfulPersonalDictionary.Dao;

import com.genspark.RestfulPersonalDictionary.Entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryDao extends JpaRepository<Entry, Integer> {
}
