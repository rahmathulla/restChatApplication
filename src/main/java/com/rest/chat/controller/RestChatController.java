package com.rest.chat.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.chat.domain.*;
import com.rest.chat.entity.ChatRoomEntity;
import com.rest.chat.entity.UserEntity;
import com.rest.chat.util.MemoryDBUtil;
import com.rest.chat.util.RestChatConstants;

@RestController
@RequestMapping(RestChatConstants.REST_CHAT_SERVER)
public class RestChatController {
	@Autowired 
	private HttpServletRequest request;

	@SuppressWarnings("static-access")
	@RequestMapping(value = RestChatConstants.USER_SIGNUP, method = RequestMethod.POST)
	public @ResponseBody UserDocument userSignup(@RequestBody UserDocument usrDoc) {
		if (usrDoc != null) {
			String currentDate = RestChatConstants.dateFormat.format(new Date());
			usrDoc.setCreatedDate(currentDate);
				
			// In memory DB (HSQL) Storage
			MemoryDBUtil memDbUtil = new MemoryDBUtil();
			UserEntity user = new UserEntity();
			Session session = memDbUtil.getSessionFactory().openSession();
			session.beginTransaction();
			user.setUserId(usrDoc.getUserId());
			user.setUserName(usrDoc.getUserName());
			user.setCreatedDate(usrDoc.getCreatedDate());
			user.setEmail(usrDoc.getEmail());
			session.save(user);
			 session.getTransaction().commit();
		}
		 return  usrDoc;
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value = RestChatConstants.CHAT_CREATE, method = RequestMethod.POST)
	public @ResponseBody String createChatRoom( @RequestBody ChatRoomDocument chatRoom) {
		String response = "";
		if(chatRoom.getRoomName() != null) {
			// In memory DB (HSQL) Storage
			MemoryDBUtil memDbUtil = new MemoryDBUtil();
			ChatRoomEntity chatRoomEntity = new ChatRoomEntity();
			Session session = memDbUtil.getSessionFactory().openSession();
			session.beginTransaction();
			chatRoomEntity.setRoomId(chatRoom.getRoomId());
			chatRoomEntity.setRoomName(chatRoom.getRoomName());
			session.save(chatRoomEntity);
			session.getTransaction().commit(); 
			response = "Created chat room :"+chatRoom.getRoomName();
		} else {
			response = "Room name is mandatory !!!";
		}
		 return  response;
	}
	
	@RequestMapping(value = RestChatConstants.CHAT_JOIN, method = RequestMethod.POST)
	public @ResponseBody String joinChatRoom(@RequestBody  ChatRoomUserDocument roomUsr) {
		String response = "";
		if (roomUsr.getChatRoom().getRoomName() != null && roomUsr.getUser().getUserName() != null) {
			roomUsr.setLoginTime(RestChatConstants.timeFormat.format(new Date()));
			response = "User "+roomUsr.getUser().getUserName()+ " joined in "+roomUsr.getChatRoom().getRoomName()+
						" at "+roomUsr.getLoginTime();
		}  else {
			response = "Room name and user name is mandatory !!!";
		}
		 return  response;
	}
	
	@RequestMapping(value = RestChatConstants.CHAT_POST, method = RequestMethod.POST)
	public @ResponseBody String postmessage(@RequestBody ChatRoomUserMsgDocument msg) {
		String response = "";
		if (msg.getMessage().getMessageContent() != null) {
			response = "User : "+msg.getUser().getUserName()+
						", Room : "+msg.getChatRoom().getRoomName()+ 
						", Message : "+msg.getMessage().getMessageContent();
							
		} else {
			response = "No Messages to read";
		}
		return response;
	}
	
}
