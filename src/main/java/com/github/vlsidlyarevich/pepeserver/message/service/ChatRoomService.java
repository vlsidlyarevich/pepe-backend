package com.github.vlsidlyarevich.pepeserver.message.service;

import com.github.vlsidlyarevich.pepeserver.message.domain.ChatRoom;

/**
 * ChatRoomService
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/13/21.
 */
public interface ChatRoomService {

    ChatRoom save(ChatRoom toSave);
}
