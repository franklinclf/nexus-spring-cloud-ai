package br.ufrn.imd.ai.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public class DataService {
    private final VectorStore vectorStore;
    private final TokenTextSplitter textSplitter = new TokenTextSplitter();

    public DataService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public VectorStore getStore() {
        return vectorStore;
    }

    public ResponseEntity<String> uploadFile(MultipartFile file) {
        TikaDocumentReader reader = new TikaDocumentReader(file.getResource());
        List<Document> documents = reader.read();
        List<Document> chunks = textSplitter.split(documents);
        vectorStore.add(chunks);
        return ResponseEntity.ok("Arquivo: " + file.getOriginalFilename() + " (" + file.getSize() + " bytes) carregado com sucesso.");
    }
}
