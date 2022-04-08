package com.cos.photogram.service;

import com.cos.photogram.config.auth.PrincipalDetails;
import com.cos.photogram.domain.image.Image;
import com.cos.photogram.domain.image.ImageRepository;
import com.cos.photogram.web.dto.image.ImageUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Transactional(readOnly = true)
    public Page<Image> imageStory(int principalId, Pageable pageable) {
        Page<Image> images = imageRepository.mStory(principalId, pageable);
        return images;
    }

    @Value("${file.path}")
    private String uploadFolder;

    @Transactional
    public void imageUpload(ImageUploadDto imageUploadDto, PrincipalDetails principalDetails) {

        UUID uuid = UUID.randomUUID();
        String imageFileName = uuid + "_" + imageUploadDto.getFile().getOriginalFilename();

        Path imageFilePath = Paths.get(uploadFolder + imageFileName);

        // Communication, I/O -> can occur exception
        try {
            Files.write(imageFilePath, imageUploadDto.getFile().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // save to image table
        Image image = imageUploadDto.toEntity(imageFileName, principalDetails.getUser());
        imageRepository.save(image);

    }

}
