package com.develop_mouse.gummy_dang.comment.controller;

import com.develop_mouse.gummy_dang.comment.domain.request.CommentRequest;
import com.develop_mouse.gummy_dang.comment.domain.response.CommentResponse;
import com.develop_mouse.gummy_dang.comment.service.CommentService;
import com.develop_mouse.gummy_dang.common.domain.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //한 post 내에 댓글 리스트 확인
    @GetMapping("/post/{postId}/comment")
    public Response<List<CommentResponse>> listComments(@PathVariable Long postId) {
        return commentService.listComments(postId);
    }

    // 댓글 작성
    @PostMapping("/post/{postId}/comment")
    public Response<CommentResponse> createComment(@PathVariable Long postId, @RequestBody CommentRequest commentRequest) {
        return commentService.createComment(commentRequest);
    }

    // 댓글 수정
    @PatchMapping("/post/{postId}/comment")
    public Response<CommentResponse> updateComment(@PathVariable Long postId, @RequestBody CommentRequest commentRequest) {
        return commentService.updateComment(commentRequest);
    }

    // 댓글 삭제
    @DeleteMapping("/post/{postId}/comment")
    public Response<Void> deleteComment(@RequestBody CommentRequest commentRequest) {
        return commentService.deleteComment(commentRequest);
    }



}