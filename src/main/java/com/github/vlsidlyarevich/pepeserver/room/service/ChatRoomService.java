package com.github.vlsidlyarevich.pepeserver.room.service;

import com.github.vlsidlyarevich.pepeserver.room.domain.ChatRoom;

import java.util.List;

/**
 * ChatRoomService
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/13/21.
 */
public interface ChatRoomService {

    ChatRoom create(String name, List<String> userIds);
}
