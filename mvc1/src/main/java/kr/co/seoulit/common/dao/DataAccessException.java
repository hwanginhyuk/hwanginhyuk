package kr.co.seoulit.common.dao;

@SuppressWarnings("serial")
public class DataAccessException extends RuntimeException{
	public DataAccessException(String msg){ super(msg); }
}
