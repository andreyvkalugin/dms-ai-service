package ru.kalugin.ai.config

import dev.langchain4j.data.document.loader.FileSystemDocumentLoader
import dev.langchain4j.data.document.parser.TextDocumentParser
import dev.langchain4j.data.document.splitter.DocumentSplitters
import dev.langchain4j.data.segment.TextSegment
import dev.langchain4j.model.TokenCountEstimator
import dev.langchain4j.model.embedding.EmbeddingModel
import dev.langchain4j.rag.content.retriever.ContentRetriever
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever
import dev.langchain4j.store.embedding.EmbeddingStore
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ResourceLoader
import java.io.IOException


@Configuration
class CustomerSupportAgentConfiguration {

    @Bean
    fun embeddingStore(
        embeddingModel: EmbeddingModel,
        resourceLoader: ResourceLoader
    ): EmbeddingStore<TextSegment> {
        val embeddingStore: EmbeddingStore<TextSegment> = InMemoryEmbeddingStore()

        val resource = resourceLoader.getResource("classpath:miles-of-smiles-terms-of-use.txt")
        val document = FileSystemDocumentLoader.loadDocument(resource.file.toPath(), TextDocumentParser())

        val ingestor = EmbeddingStoreIngestor.builder()
            .embeddingModel(embeddingModel)
            .embeddingStore(embeddingStore)
            .build()
        ingestor.ingest(document)
        return embeddingStore
    }

    @Bean
    fun contentRetriever(
        embeddingStore: EmbeddingStore<TextSegment?>?,
        embeddingModel: EmbeddingModel?
    ): ContentRetriever {
        val maxResults = 1
        val minScore = 0.6
        return EmbeddingStoreContentRetriever.builder()
            .embeddingStore(embeddingStore)
            .embeddingModel(embeddingModel)
            .maxResults(maxResults)
            .minScore(minScore)
            .build()
    }
}