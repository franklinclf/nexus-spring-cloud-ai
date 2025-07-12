package br.ufrn.imd.ai.data;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VectorStoreDao {
    private final SimpleVectorStore simpleVectorStore;

    public VectorStoreDao(SimpleVectorStore simpleVectorStore) {
        this.simpleVectorStore = simpleVectorStore;
    }

    public void add(List<Document> documents) {
        simpleVectorStore.add(documents);
    }

    public SimpleVectorStore getStore() {
        return this.simpleVectorStore;
    }
}
