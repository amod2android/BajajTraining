package com.amod.fileuploaddemo.controllers;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @PostMapping("/create")
    public ResponseEntity<Object> createProduct(@RequestParam("productFile")MultipartFile productFile){
        AmazonS3 amazonS3= AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.US_EAST_1)
                .build();


        System.out.println(productFile.getOriginalFilename());

        try {
            amazonS3.putObject("aws-amod-sample-bucket","productFile.jpeg",productFile.getInputStream(),new ObjectMetadata());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity("Working", HttpStatus.OK);
    }
}
