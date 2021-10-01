package io.example.gcp.storage.controller

import io.example.gcp.storage.service.GcpStorageService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

/**
 * @author : choi-ys
 * @date : 2021-10-01 오전 11:02
 */
@RestController
@RequestMapping(
    "download",
    consumes = [MediaType.APPLICATION_JSON_VALUE],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class DownloadController(
    private val gcpStorageService: GcpStorageService
) {

    @GetMapping
    fun download(
        @RequestParam(value = "filename") filename: String,
        httpServletResponse: HttpServletResponse
    ): ResponseEntity<*> =
        ResponseEntity.ok(gcpStorageService.download(filename, httpServletResponse))
}