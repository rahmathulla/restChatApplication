package com.rest.chat.util;

import java.text.SimpleDateFormat;

public class RestChatConstants {
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	public static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	public static final String REST_CHAT_SERVER = "/";
	public static final String USER_SIGNUP = "user/signup";
	public static final String CHAT_CREATE = "chat/create";
	public static final String CHAT_JOIN = "chat/join";
	public static final String CHAT_POST = "chat/post";
}