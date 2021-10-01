package io.example.gcp.storage.repository

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 * @author : choi-ys
 * @date : 2021-10-01 오후 7:40
 * Edit Configurations > Environment variables > 
 * GOOGLE_APPLICATION_CREDENTIALS=c:/Users/arura/git/Repository/example-spring-boot-gcp/storage/src/main/resources/spring-boot-gcp-example-f0c868850e73.json
 */
@SpringBootTest
internal class GcpStorageComponentTest {

    @Autowired
    lateinit var gcpStorageComponent: GcpStorageComponent

    @Test
    internal fun getFileList() {
        val bucketList = gcpStorageComponent.getFileList()
    }
}