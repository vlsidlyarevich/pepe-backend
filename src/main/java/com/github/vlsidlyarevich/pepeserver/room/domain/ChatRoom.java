package com.github.vlsidlyarevich.pepeserver.room.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * ChatRoom model.
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/13/21.
 */
@Getter
@ToString
@EqualsAndHashCode
@Document(collection = "chat-rooms")
public class ChatRoom {

    @Id
    private String id;
    private final String name;
    private final List<ChatMessage> messages = new ArrayList<>();
    private final ChatMessage linkedMessage;
    private final LocalDateTime createdAt;
    private final List<String> userIds = new ArrayList<>();

    public ChatRoom(final String name,
                    final List<ChatMessage> messages,
                    final ChatMessage linkedMessage,
                    final LocalDateTime createdAt,
                    final List<String> userIds) {
        this.name = name;
        this.messages.addAll(messages);
        this.linkedMessage = linkedMessage;
        this.createdAt = createdAt;
        this.userIds.addAll(userIds);
    }

    public void setId(final String id) {
        this.id = id;
    }
}