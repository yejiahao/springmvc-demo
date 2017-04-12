package org.yejh.shop.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Created by Ye Jiahao on 2017/03/19.
 */
public class XmlUtil {
	private XmlUtil() {
		throw new AssertionError();
	}

	public static Element getRootElement(HttpSession session, String path) throws Exception {
		String realPath = session.getServletContext().getRealPath("/WEB-INF/classes");
		File xmlFile = new File(realPath + path);
		SAXReader reader = new SAXReader();
		Document document = reader.read(xmlFile);
		Element root = document.getRootElement();
		return root;
	}

	public static List<Map<String, String>> getSubAttr(Element root, String subName) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Iterator<?> iterator = root.elementIterator(subName);
		while (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			String postcode = element.attribute("postcode").getStringValue();
			String name = element.attribute("name").getStringValue();
			Map<String, String> map = new HashMap<String, String>();
			map.put("postcode", postcode);
			map.put("name", name);
			list.add(map);
		}
		return list;
	}

	public static Element getSubElement(Element element, String tag, String sourceCode) {
		Iterator<?> iterator = element.elementIterator(tag);
		while (iterator.hasNext()) {
			Element subElement = (Element) iterator.next();
			String postCode = subElement.attribute("postcode").getStringValue();
			if (postCode.equals(sourceCode)) {
				return subElement;
			}
		}
		return null;
	}

}
