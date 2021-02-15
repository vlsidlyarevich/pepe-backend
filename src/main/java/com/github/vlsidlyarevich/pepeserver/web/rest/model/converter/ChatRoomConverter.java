package com.github.vlsidlyarevich.pepeserver.web.rest.model.converter;

import com.github.vlsidlyarevich.pepeserver.room.domain.ChatRoom;
import com.github.vlsidlyarevich.pepeserver.web.rest.model.CreateChatRoomResponse;
import com.github.vlsidlyarevich.pepeserver.web.rest.model.mapper.ChatRoomMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ChatRoomConverter
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 2/15/21.
 */
@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ChatRoomConverter {

    private final ChatRoomMapper mapper;

    public CreateChatRoomResponse toResponse(ChatRoom chatRoom) {
        return mapper.fromDomain(chatRoom);
    }
}
