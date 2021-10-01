package io.example.gcp.storage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author : choi-ys
 * @date : 2021-10-01 오전 11:00
 */
@SpringBootApplication
class GcpStorageApplication

fun main(args: Array<String>) {
    runApplication<GcpStorageApplication>(*args)
}