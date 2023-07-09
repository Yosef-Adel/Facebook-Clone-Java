package com.facebookclonejava.controller.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CommentRequest {

    @NonNull
    String text;

    long PostId;
}
