/**
 * 
 */
package com.abhishek.code;

/**
 * @author Abhishek
 *
 */
public class StringRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringRotation sr = new StringRotation();
		boolean result = sr.isRotation("abc", "bca");
		System.out.println("Result :"+result);
	}
	
	public boolean isRotation(String source, String target) {
		return this.isRotation("", source, target);
	}
	
	public boolean isRotation(String prefix, String suffix, String target) {
		if(suffix==null || suffix.isEmpty())
			return false;
		String source = prefix+suffix;
		if(source.equals(target)) {
			return true;
		}
		prefix = suffix.charAt(suffix.length()-1) + prefix;
		suffix = suffix.substring(0, suffix.length()-1);
		return isRotation(prefix, suffix, target);
	}

}