package org.yejh.demo.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

public class Dom4JTest {
    public static void main(String[] args) throws Exception {
        File xmlFile = new File("src/test/resources/dom4j.xml");
        System.out.println("absolutePath: " + xmlFile.getAbsolutePath());

        SAXReader reader = new SAXReader();
        Document document = reader.read(xmlFile);
        Element root = document.getRootElement();
        Iterator<?> iterator = root.elementIterator("RRR");
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            System.out.println(element.attribute(0).getValue());
            String city = element.elementText("R2R");
            String area = element.elementText("R3R");
            String city2 = element.element("R2R").getStringValue();
            System.out.println("city2: " + city2);
            System.out.println("city: " + city + ",  area: " + area);
        }
    }
}
