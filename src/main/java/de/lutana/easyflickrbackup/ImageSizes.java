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

import com.flickr4java.flickr.photos.Size;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ImageSizes {
	
	private Map<Integer,String> suffix;
	private List<Entry<Integer,String>> names;
	private Map<Integer,String> namesMap;
	
	public ImageSizes() {
		suffix = new HashMap<>();
		suffix.put(Size.SQUARE, "_s");
		suffix.put(Size.SQUARE_LARGE, "_q");
		suffix.put(Size.THUMB, "_t");
		suffix.put(Size.SMALL, "_m");
		suffix.put(Size.SMALL_320, "_n");
		suffix.put(Size.MEDIUM, "");
		suffix.put(Size.MEDIUM_640, "_z");
		suffix.put(Size.MEDIUM_800, "_c");
		suffix.put(Size.LARGE, "_b");
		suffix.put(Size.LARGE_1600, "_h");
		suffix.put(Size.LARGE_2048, "_k");
		suffix.put(Size.ORIGINAL, "_o");
		
		names = new ArrayList<>();
		names.add(new AbstractMap.SimpleEntry<>(Size.SQUARE, "Square (75px)"));
		names.add(new AbstractMap.SimpleEntry<>(Size.SQUARE_LARGE, "Square (150px)"));
		names.add(new AbstractMap.SimpleEntry<>(Size.THUMB, "Thumbnail (100px)"));
		names.add(new AbstractMap.SimpleEntry<>(Size.SMALL, "Small (320px)"));
		names.add(new AbstractMap.SimpleEntry<>(Size.SMALL_320, "Small (320px)"));
		names.add(new AbstractMap.SimpleEntry<>(Size.MEDIUM, "Medium (500px)"));
		names.add(new AbstractMap.SimpleEntry<>(Size.MEDIUM_640, "Medium (640px)"));
		names.add(new AbstractMap.SimpleEntry<>(Size.MEDIUM_800, "Medium (800px)"));
		names.add(new AbstractMap.SimpleEntry<>(Size.LARGE, "Large (1024px)"));
		names.add(new AbstractMap.SimpleEntry<>(Size.LARGE_1600, "Large (1600px)"));
		names.add(new AbstractMap.SimpleEntry<>(Size.LARGE_2048, "Large (2048px)"));
		names.add(new AbstractMap.SimpleEntry<>(Size.ORIGINAL, "Original"));
		
		namesMap = new HashMap<>();
		Iterator<Entry<Integer,String>> it = names.iterator();
		while (it.hasNext()) {
			Entry<Integer,String> entry = it.next();
			namesMap.put(entry.getKey(), entry.getValue());
		}
	}
	
	public String getSuffix(int size) {
		try {
			return suffix.get(size);
		} catch(Exception e) {
			return null;
		}
	}
	
	public List<Entry<Integer,String>> getAllNames() {
		return names;
	}
	
	public String getName(int size) {
		try {
			return namesMap.get(size);
		} catch(Exception e) {
			return "";
		}
	}
	
}
