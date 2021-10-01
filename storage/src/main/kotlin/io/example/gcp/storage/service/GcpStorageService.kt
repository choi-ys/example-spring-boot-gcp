package io.example.gcp.storage.service

import io.example.gcp.storage.repository.GcpStorageComponent
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletResponse

/**
 * @author : choi-ys
 * @date : 2021-10-01 오전 11:03
 */
@Service
class GcpStorageService(
    private val gcpStorageComponent: GcpStorageComponent
) {

    fun upload(uploadFileName: String, multipartFile: MultipartFile) =
        gcpStorageComponent.uploadGcpStorage(uploadFileName, multipartFile.inputStream)

    fun download(gcpFilename: String, httpServletResponse: HttpServletResponse) =
        gcpStorageComponent.downloadGcpStorage(gcpFilename, httpServletResponse)
}