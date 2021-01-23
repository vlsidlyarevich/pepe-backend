package com.github.vlsidlyarevich.pepeserver;

import com.github.vlsidlyarevich.pepeserver.room.domain.ChatMessage;
import com.github.vlsidlyarevich.pepeserver.room.domain.ChatRoom;
import com.github.vlsidlyarevich.pepeserver.room.domain.MessageStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ChatRoomGenerator
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/23/21.
 */
public class ChatRoomGenerator {

    public static final String DEFAULT_NAME = "pepe-gang";
    public static final List<ChatMessage> DEFAULT_MESSAGES = new ArrayList<>();
    public static final List<String> DEFAULT_USER_IDS = Arrays.asList("user1", "user2");

    static {
        ChatMessage chatMessage = new ChatMessage("message-id", "chat-id", "sender-id",
                "recipient-id", "sender-name", "recipient-name",
                "message-content", LocalDateTime.now(), MessageStatus.NON_READED);
        DEFAULT_MESSAGES.add(chatMessage);
    }

    private ChatRoomGenerator() {
        throw new IllegalArgumentException("Can't create instance of utility class");
    }

    public static ChatRoom generateChatRoom() {
        return new ChatRoom(DEFAULT_NAME,
                DEFAULT_MESSAGES,
                DEFAULT_MESSAGES.get(0),
                LocalDateTime.now(),
                DEFAULT_USER_IDS);
    }
}
