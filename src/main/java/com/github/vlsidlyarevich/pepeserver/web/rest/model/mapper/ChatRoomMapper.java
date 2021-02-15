package com.github.vlsidlyarevich.pepeserver.web.rest.model.mapper;

import com.github.vlsidlyarevich.pepeserver.room.domain.ChatRoom;
import com.github.vlsidlyarevich.pepeserver.web.rest.model.CreateChatRoomResponse;
import org.mapstruct.Mapper;

/**
 * ChatRoomMapper
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 2/15/21.
 */
@Mapper(componentModel = "spring")
public interface ChatRoomMapper {

    CreateChatRoomResponse fromDomain(ChatRoom chatRoom);
}
