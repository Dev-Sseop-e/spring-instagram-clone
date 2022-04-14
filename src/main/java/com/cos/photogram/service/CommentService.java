package com.cos.photogram.service;

import com.cos.photogram.domain.comment.Comment;
import com.cos.photogram.domain.comment.CommentRepository;
import com.cos.photogram.domain.image.Image;
import com.cos.photogram.domain.user.User;
import com.cos.photogram.domain.user.UserRepository;
import com.cos.photogram.handler.ex.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Transactional
    public Comment addCmt(String content, int imageId, int userId) {

        // when making object, insert id only
        // therefore, it just returns image and user objects which have only id value
        Image image = new Image();
        image.setId(imageId);

        User userEntity = userRepository.findById(userId).orElseThrow(() -> {
            throw new CustomApiException("Can't find user id");
        });

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setImage(image);
        comment.setUser(userEntity);

        return commentRepository.save(comment);
    }

    @Transactional
    public void deleteCmt(int id) {
        try { // when it occurs error
            commentRepository.deleteById(id);
        } catch(Exception e) {
            throw new CustomApiException(e.getMessage());
        }
    }

}
