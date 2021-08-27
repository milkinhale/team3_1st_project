package kosta.mvc.session;

import java.util.HashMap;
import java.util.Map;

/**
 * ����� ��ü
 * 
 * �α��ε� ������� ������, �α����� �����Ǵ� ���� Session��ü�� �����ؼ� �����Ѵ�. 
 * 
 * */
public class Session {
	private String sessionId;
	
	
	public Session() {}
	public Session(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
	public String getSessionId() {
		return sessionId;
	}
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Session [sessionId=");
		builder.append(sessionId);
		builder.append("]");
		return builder.toString();
	}
	
	/**
	 * ������ session�� ���ÿ� �α��ε��� �ʵ��� Ȯ���Ѵ�. */
	@Override
	public int hashCode() {
		return sessionId.hashCode();
	}
	
	/**
	 * ���� ��ü��� ���� hashCode�� ���ƾ��ϰ�,
	 * equals�� ����� true�����Ѵ�.
	 * 
	 *  hash�ڵ尡 �ٸ��� ������ �ٸ� ��ü
	 *  hash�ڵ尡 ������ ���� ��ü�ϼ���, �ٸ� ��ü�ϼ��� �ִ�.
	 * */
	@Override
	public boolean equals(Object obj) {
		Session other = (Session) obj;
		if(sessionId.equals(other.sessionId)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
//		return result;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Session other = (Session) obj;
//		if (sessionId == null) {
//			if (other.sessionId != null)
//				return false;
//		} else if (!sessionId.equals(other.sessionId))
//			return false;
//		return true;
//	}
	
	
	
	
	
}
