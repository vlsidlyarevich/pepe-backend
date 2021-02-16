package com.github.vlsidlyarevich.pepeserver.web.rest.model.mapper;

import com.github.vlsidlyarevich.pepeserver.room.domain.ChatRoom;
import com.github.vlsidlyarevich.pepeserver.web.rest.model.CreateChatRoomResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-16T20:38:06+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class ChatRoomMapperImpl implements ChatRoomMapper {

    @Override
    public CreateChatRoomResponse fromDomain(ChatRoom chatRoom) {
        if ( chatRoom == null ) {
            return null;
        }

        CreateChatRoomResponse createChatRoomResponse = new CreateChatRoomResponse();

        createChatRoomResponse.setId( chatRoom.getId() );
        createChatRoomResponse.setName( chatRoom.getName() );
        createChatRoomResponse.setCreatedAt( chatRoom.getCreatedAt() );
        List<String> list = chatRoom.getUserIds();
        if ( list != null ) {
            createChatRoomResponse.setUserIds( new ArrayList<String>( list ) );
        }

        return createChatRoomResponse;
    }
}
