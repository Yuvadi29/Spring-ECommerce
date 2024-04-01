package com.example.server.Shukra.Service.Product;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.server.Shukra.Model.Product;
import com.example.server.Shukra.Repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AmazonS3 amazonS3;

    @Override
    public Product addProduct(
            String productCategories,
            String subcategories,
            String productName,
            String description,
            Number purchasePrice,
            Number mrpPrice,
            Number profit,
            Number productQuantity,
            Number stockQuantity,
            String color,
            Number size,
            MultipartFile[] photos,
            MultipartFile[] productDetailPhotos) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(photos[0].getContentType());

            ObjectId objectId = new ObjectId();

            String folderPath = "Images/Products/" + objectId.toHexString() + "/";

            // Upload main product photos to S3
            for (int i = 0; i < photos.length; i++) {
                String fileName = "productImage_" + (i + 1) + ".png"; // Naming convention for photos
                String s3Key = folderPath + fileName;

                // Upload photo to S3
                PutObjectRequest request = new PutObjectRequest(bucketName, s3Key, photos[i].getInputStream(),
                        metadata);
                amazonS3.putObject(request);
            }

            Product product = new Product(
                    productCategories,
                    subcategories,
                    productName,
                    description,
                    purchasePrice,
                    mrpPrice,
                    profit,
                    productQuantity,
                    stockQuantity,
                    color,
                    size,
                    null,
                    null,
                    objectId);

            return this.productRepository.save(product);

        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("Failed to process file: ", e);
        }
    }
}
