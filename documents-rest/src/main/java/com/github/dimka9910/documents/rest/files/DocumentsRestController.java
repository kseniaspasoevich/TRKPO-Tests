package com.github.dimka9910.documents.rest.files;

import com.github.dimka9910.documents.dto.files.documents.ConcreteDocumentDto;
import com.github.dimka9910.documents.dto.files.documents.DocumentDto;
import com.github.dimka9910.documents.service.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentsRestController {

    @Autowired
    DocumentService documentService;

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DocumentDto getDocument(@PathVariable Long id) {
        return documentService.getDocumentById(id);
    }

    @GetMapping(value = "/{id}/versions",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ConcreteDocumentDto> getAllDocumentVersions(@PathVariable Long id) {
        return documentService.getAllVersionsById(id);
    }

    @PostMapping(value = "",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public DocumentDto addNewDocument(@RequestBody @Valid DocumentDto documentDto){
        return documentService.saveNewDocument(documentDto, documentDto.getConcreteDocument());
    }

    @PostMapping(value = "/modify",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public DocumentDto modifyDocument(@RequestBody @Valid ConcreteDocumentDto concreteDocumentDto){
        return documentService.modifyDocument(concreteDocumentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDocument(@PathVariable Long id){
        documentService.deleteDocumentById(id);
        return ResponseEntity.ok("ok");
    }

}
