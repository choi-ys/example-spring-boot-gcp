package io.example.gcp.storage.repository

import com.google.api.gax.paging.Page
import com.google.cloud.storage.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.InputStream
import javax.servlet.http.HttpServletResponse

/**
 * @author : choi-ys
 * @date : 2021-10-01 오전 11:10
 * https://jyami.tistory.com/54
 */
@Component
class GcpStorageComponent {

    @Value("\${gcp.project-id}")
    lateinit var PROJECT_ID: String

    @Value("\${gcp.bucket-name}")
    lateinit var BUCKET_NAME: String

    private fun createBlobInfo(bucketName: String, objectName: String) =
        BlobInfo.newBuilder(bucketName, objectName).build()

    private fun getStorage() =
        StorageOptions.newBuilder().setProjectId(PROJECT_ID).build().service

    fun uploadGcpStorage(objectName: String, file: InputStream) =
        getStorage().create(createBlobInfo(BUCKET_NAME, objectName), file.readAllBytes())

    fun downloadGcpStorage(objectName: String, httpServletResponse: HttpServletResponse) {
        val blob = getStorage().get(BlobId.of(BUCKET_NAME, objectName))
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"$objectName\";")
        httpServletResponse.setHeader("Content-Transfer-Encoding", "binary")
        blob.downloadTo(httpServletResponse.outputStream)
    }

    fun getBucketList(): Page<Bucket> = getStorage().list()

    fun getBucketDetails(): Bucket =
        getStorage().get(BUCKET_NAME, Storage.BucketGetOption.fields(*Storage.BucketField.values()))

    fun getFileList(): Page<Blob> = getStorage().list(BUCKET_NAME, Storage.BlobListOption.currentDirectory())
}