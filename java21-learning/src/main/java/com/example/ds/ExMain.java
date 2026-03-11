package com.example.ds;

class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3749894200029844216L;
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}

public class ExMain {
	public static void main(String[] args) {
		String m = null;
		try {
			m1(m);
		} catch (ResourceNotFoundException e) {
//			System.out.println(e.getMessage() + m);
			throw e;
		} catch (Exception e) {
			System.out.println("Some Exception: " + e);
		}
	}

	private static String m1(String msg) {
		if (msg == null) {
			throw new ResourceNotFoundException("msg is null");
		}
		return msg;
	}
}
