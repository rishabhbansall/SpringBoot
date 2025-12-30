package com.edigest.journalApp.service;

import com.edigest.journalApp.entity.JournalEntry;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JournalEntryService {

    private final Map<Long, JournalEntry> journalEntries = new HashMap<>();
    private Long idCounter = 1L; // Auto-increment counter

    // Get all journal entries
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    // Save a new journal entry with auto-generated ID
    public synchronized JournalEntry saveEntry(JournalEntry entry) {
        // Auto-generate ID if not provided or if it's null
        if (entry.getId() == null) {
            entry.setId(idCounter++);
            System.out.println("Auto-generated ID: " + entry.getId());
        } else {
            System.out.println("Using provided ID: " + entry.getId());
            // If ID is provided, make sure counter is higher than it
            if (entry.getId() >= idCounter) {
                idCounter = entry.getId() + 1;
            }
        }
        journalEntries.put(entry.getId(), entry);
        System.out.println("Saved entry with ID: " + entry.getId() + ", Title: " + entry.getTitle());
        return entry;
    }
    }

    // Find journal entry by ID
    public Optional<JournalEntry> findById(Long id) {
        return Optional.ofNullable(journalEntries.get(id));
    }

    // Delete journal entry by ID
    public void deleteById(Long id) {
        journalEntries.remove(id);
    }

    // Update journal entry
    public JournalEntry updateEntry(Long id, JournalEntry entry) {
        entry.setId(id);
        journalEntries.put(id, entry);
        return entry;
    }

    // Get journal entries by username
    public List<JournalEntry> getByUsername(String username) {
        return journalEntries.values().stream()
                .filter(entry -> username.equals(entry.getUsername()))
                .toList();
    }
}

