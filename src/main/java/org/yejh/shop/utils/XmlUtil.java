package org.yejh.shop.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

/**
 * Created by Ye Jiahao on 2017/03/19.
 */
public class XmlUtil {
    private XmlUtil() {
        throw new AssertionError();
    }

    public static Element getRootElement(HttpSession session, String filePath) throws Exception {
        String realPath = session.getServletContext().getRealPath("/WEB-INF/classes");
        File xmlFile = new File(realPath + filePath);
        SAXReader reader = new SAXReader();
        Document document = reader.read(xmlFile);
        Element root = document.getRootElement();
        return root;
    }

    public static List<Map<String, String>> elementToMap(List<Element> list, String... args) {
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map = null;

        for (int i = 0, size = list.size(); i < size; i++) {
            Element element = list.get(i);
            map = new HashMap<>();
            for (String param : args) {
                map.put(param, element.attribute(param).getText());
            }
            mapList.add(map);
        }
        return mapList;
    }

    public static List<Element> listNodes(Element element) {
        return listNodes(element, null);
    }

    public static List<Element> listNodes(Element root, String sourceCode) {
        List<Element> list = new ArrayList<>();

        Iterator<?> iterator = root.elementIterator();
        if (sourceCode != null) {
            while (iterator.hasNext()) {
                Element element = (Element) iterator.next();
                String postCode = element.attribute("postcode").getText();
                if (postCode.equals(sourceCode)) {
                    list.add(element);
                    break;
                }
            }
        } else {
            while (iterator.hasNext()) {
                Element element = (Element) iterator.next();
                list.add(element);
            }
        }
        return list;
    }

}
