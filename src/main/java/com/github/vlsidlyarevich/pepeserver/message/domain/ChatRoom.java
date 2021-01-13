package com.github.vlsidlyarevich.pepeserver.message.domain;

import lombok.Value;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ChatRoom
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/13/21.
 */
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