package com.rest.chat.domain;

public class ChatRoomUserMsgDocument {
	private ChatRoomDocument chatRoom;

	private UserDocument user;
	
	private MessageDocument message;

	public ChatRoomDocument getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoomDocument chatRoom) {
		this.chatRoom = chatRoom;
	}

	public UserDocument getUser() {
		return user;
	}

	public void setUser(UserDocument user) {
		this.user = user;
	}

	public MessageDocument getMessage() {
		return message;
	}

	public void setMessage(MessageDocument message) {
		this.message = message;
	}
}
