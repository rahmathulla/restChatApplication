package com.rest.chat.domain;

public class MessageDocument {
private long id;

private String messageContent;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getMessageContent() {
	return messageContent;
}

public void setMessageContent(String messageContent) {
	this.messageContent = messageContent;
}


}
