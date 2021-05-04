package com.github.dimka9910.documents.jpa.repository;

import com.github.dimka9910.documents.jpa.entity.files.documents.Document;
import com.github.dimka9910.documents.jpa.entity.files.documents.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {

    Optional<DocumentType> findByName(String name);

}
