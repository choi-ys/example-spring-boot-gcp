package io.example.gcp.storage.controller

import io.example.gcp.storage.service.GcpStorageService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

/**
 * @author : choi-ys
 * @date : 2021-10-01 오전 11:02
 */
@RestController
@RequestMapping(
    "upload",
//    consumes = [MediaType.MULTIPART_FORM_DATA_VALUE],
//    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class UploadController(
    private val gcpStorageService: GcpStorageService
) {

    @PostMapping
    fun upload(@RequestPart(value = "file") multipartFile: MultipartFile): ResponseEntity<*> =
        ResponseEntity.ok(gcpStorageService.upload(multipartFile.originalFilename.let { "default-filename" }, multipartFile))
}