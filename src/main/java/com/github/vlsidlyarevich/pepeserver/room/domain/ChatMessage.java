package com.github.vlsidlyarevich.pepeserver.room.domain;

import lombok.Value;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * ChatMessage
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/13/21.
 */
@Value
public class ChatMessage {

    @Id
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
