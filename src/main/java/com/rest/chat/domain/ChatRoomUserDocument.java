package com.rest.chat.domain;


public class ChatRoomUserDocument {

	private UserDocument user;

	private ChatRoomDocument chatRoom;
	
	private String loginTime;
	
	public UserDocument getUser() {
		return user;
	}

	public void setUser(UserDocument user) {
		this.user = user;
	}

	public ChatRoomDocument getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoomDocument chatRoom) {
		this.chatRoom = chatRoom;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	
}
