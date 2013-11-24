/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.efinkg.alfred;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;

import android.util.Log;

/**
 * @author Oleg Zhurakousky
 * 
 */
public class SendInstantMessageSample {

	@Test
	public static void runDemo(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SendInstantMessageSample-context.xml");
		Log.i("Trying to send a message","Finding myself.");
		MessageChannel toUserChannel = (MessageChannel) context.getBean(
				"toUserChannel", MessageChannel.class);
		Log.i("Trying to send a message","Finding you.");
		Message<String> message = new GenericMessage<String>(
				"Hello from Spring Integration XMPP");
		Log.i("Trying to send a message","Sending my Message.");
		toUserChannel.send(message);
	}
}
