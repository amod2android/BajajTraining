package com.bajaj;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class BucketOps {
    private ClientConfig clientConfig;

    BucketOps(ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    public void getAllBuckets() {

        List<Bucket> bucketList = this
                .clientConfig.getS3Client().listBuckets();
        bucketList.forEach((b) -> {
            System.out.println(b);
        });
    }












    public void createBucket(String bucketName) {
        if (this.clientConfig.getS3Client().doesBucketExistV2(bucketName)) {
            System.out.println("Bucket already exist");
        } else {
            Bucket bucket = this.clientConfig.getS3Client().createBucket(bucketName);
            System.out.println(bucket.getName());
        }
    }

    public void changeBucketPolicy(String bucketName, String policy) {
        this.clientConfig.getS3Client().setBucketPolicy(bucketName, policy);
    }

    public void uploadFile(String bucketName, String key, String filePath) {
        this.clientConfig.getS3Client().putObject(bucketName, key, new File(filePath));
    }


    public  void downloadFile(String bucketName,String key){
        S3Object s3Object = this.clientConfig.getS3Client().getObject(bucketName,key);
        S3ObjectInputStream s3ObjectInputStream=s3Object.getObjectContent();

        try {
            FileOutputStream fileOutputStream=new FileOutputStream(new File("/Users/amodkumar/Downloads/download.jpeg"));
            byte[] read_buff=new byte[1024];
            int read_len=0;
            while ((read_len=s3ObjectInputStream.read(read_buff))>0){
                fileOutputStream.write(read_buff,0,read_len);

            }
            s3ObjectInputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
