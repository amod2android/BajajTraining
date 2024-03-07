package com.bajaj;

public class Main {
    public static void main(String[] args) {

        ClientConfig clientConfig = new ClientConfig();
        BucketOps bucketOps = new BucketOps(clientConfig);
        bucketOps.getAllBuckets();




















/*
        // To create bucket
//        bucketOps.createBucket("mallika-java-demo");

        String policy = "{\n" +
                "\t\"Version\": \"2012-10-17\",\n" +
                "\t\"Statement\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"Sid\": \"Statement1\",\n" +
                "\t\t\t\"Principal\": \"*\",\n" +
                "\t\t\t\"Effect\": \"Allow\",\n" +
                "\t\t\t\"Action\": [\n" +
                "\t\t\t\t\"s3:GetObject\",\n" +
                "\t\t\t\t\"s3:PutObject\"\n" +
                "\t\t\t],\n" +
                "\t\t\t\"Resource\": [\"arn:aws:s3:::aws-amod-sample-bucket/*\"]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

      //  bucketOps.changeBucketPolicy("mallika-java-demo", policy);

        //To upload file in S3


//        bucketOps.uploadFile("mallika-java-demo", );

        bucketOps.downloadFile("aws-amod-sample-bucket","download.jpeg");*/

    }
}