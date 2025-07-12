package br.ufrn.imd.ai.service;

import br.ufrn.imd.ai.data.VectorStoreDao;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.markdown.MarkdownDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DataService {
    private final VectorStoreDao vectorStore;
    private final TokenTextSplitter textSplitter = new TokenTextSplitter();

    public DataService(VectorStoreDao vectorStore) {
        this.vectorStore = vectorStore;
    }

    public SimpleVectorStore getStore() {
        return vectorStore.getStore();
    }

    public ResponseEntity<String> uploadFile(MultipartFile file) throws IOException {
        MarkdownDocumentReader reader = new MarkdownDocumentReader(file.getInputStream().toString());
        List<Document> documents = reader.read();
        List<Document> chunks = textSplitter.split(documents);
        vectorStore.add(chunks);
        return ResponseEntity.ok("Arquivo: " + file.getOriginalFilename() + " (" + file.getSize() + " bytes) carregado com sucesso.");
    }
}
