package com.github.vlsidlyarevich.pepeserver.message.domain;

import lombok.Value;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Document(collection = "chat-rooms")
public class ChatRoom {

    @Id
    String id;
    String name;
    List<ChatMessage> messages;
    ChatMessage linkedMessage;
    LocalDateTime createdAt;
    List<String> userIds;
}
