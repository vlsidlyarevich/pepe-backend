package com.github.vlsidlyarevich.pepeserver.message.domain;

import lombok.Value;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Value
public class ChatMessage {

    String id;
    String chatId;
    String senderId;
    String recipientId;
    String senderName;
    String recipientName;
    String content;
    LocalDateTime timestamp;
    MessageStatus status;
}
