package kr.co.seoulit.member.exception;

@SuppressWarnings("serial")
public class MemberNonExistentException extends Exception {
	public MemberNonExistentException(String msg) {
		super(msg);
	}
}
