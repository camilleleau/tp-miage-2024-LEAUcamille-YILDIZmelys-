package com.acme.todolist;

import com.acme.todolist.domain.TodoItem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {


	@Test
	public void testFinalContentOnTime() throws Exception{
		Instant time = Instant.now();
		String content_call = "Never gonna give you up";
		TodoItem todoItem = new TodoItem("this is ID !!!", time, content_call);

		assertEquals( content_call, todoItem.finalContent(), "Le message devrait être le même si il est dans le temps imparti");
	}

	@Test
	public void testFinalContentLate() throws Exception{
		Instant time = Instant.parse("2020-02-27T10:31:43Z");
		String content_call = "Never gonna give you up";
		TodoItem todoItem = new TodoItem("0f8-06eb17ba8d34", time,content_call );

		assertEquals("[LATE!] "+content_call, todoItem.finalContent(), "Le message devrait être différent si il y a dépassé le temps imparti");
	}

}