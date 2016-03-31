/*
 * The MIT License
 *
 * Copyright 2016 Matthias.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.lutana.easyflickrbackup;

import com.flickr4java.flickr.people.User;

public abstract class StringContainer<T> {

	protected T obj;

	public StringContainer(T obj) {
		this.obj = obj;
	}

	public T get() {
		return obj;
	}

	@Override
	public abstract String toString(); {
	}
	
	public static class Auth extends StringContainer<com.flickr4java.flickr.auth.Auth> {
		
		public Auth(com.flickr4java.flickr.auth.Auth obj) {
			super(obj);
		}

		@Override
		public String toString() {
			User u = obj.getUser();
			return u.getUsername() + " (" + u.getId() + ")";
		}
		
	}

	public static class Entry extends StringContainer<java.util.Map.Entry<Integer,String>> {
		
		public Entry(java.util.Map.Entry<Integer,String> obj) {
			super(obj);
		}

		@Override
		public String toString() {
			return obj.getValue();
		}
		
	}

}
