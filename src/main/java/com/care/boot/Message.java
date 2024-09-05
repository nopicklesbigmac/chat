package com.care.boot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/*
	-- Message 테이블 생성
CREATE TABLE message (
    id NUMBER(19,0) PRIMARY KEY,
    username VARCHAR2(255 CHAR),
    content VARCHAR2(255 CHAR)
);

-- 시퀀스 생성
CREATE SEQUENCE message_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

-- 트리거 생성
CREATE OR REPLACE TRIGGER message_trigger
BEFORE INSERT ON message
FOR EACH ROW
BEGIN
    :new.id := message_seq.NEXTVAL;
END;
/
	
*/
@Entity
public class Message {
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_seq")
	    @GenericGenerator(name = "message_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
	    private Long id;

	    private String username;
	    private String content;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

    // getters and setters
}
