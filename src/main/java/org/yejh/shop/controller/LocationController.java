package org.yejh.shop.controller;

import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yejh.shop.entity.Location;
import org.yejh.shop.util.XmlUtil;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ye Jiahao on 2017/06/25.
 */
@Controller
@RequestMapping(value = "/location")
public class LocationController extends BaseController {
    @RequestMapping(value = "/getProvinces", method = {RequestMethod.GET})
    @ResponseBody
    public Object getProvinces(HttpSession session) {
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            Element root = XmlUtil.getRootElement(session, "/city.xml");
            List<Element> provinceList = XmlUtil.listNodes(root);
            mapList = XmlUtil.elementToMap(provinceList, "postcode", "name");
            LOG.info("province mapList: {}", mapList);
        } catch (Exception e) {
            LOG.error("getProvinces: ", e);
        } finally {
            return mapList;
        }
    }

    @RequestMapping(value = "/getCitiesByProvince", method = {RequestMethod.GET})
    @ResponseBody
    public Object getCitiesByProvince(HttpSession session, Location location) {
        LOG.info("enter getCitiesByProvince: {}", location);
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            Element root = XmlUtil.getRootElement(session, "/city.xml");
            List<Element> provinceList = XmlUtil.listNodes(root, location.getProvincePostCode());
            if (!provinceList.isEmpty()) {
                List<Element> cityList = XmlUtil.listNodes(provinceList.get(0));
                mapList = XmlUtil.elementToMap(cityList, "postcode", "name");
            }
            LOG.info("city mapList: {}", mapList);
        } catch (Exception e) {
            LOG.error("getCitiesByProvince: ", e);
        } finally {
            return mapList;
        }
    }

    @RequestMapping(value = "/getAreasByCity", method = {RequestMethod.GET})
    @ResponseBody
    public Object getAreasByCity(HttpSession session, Location location) {
        LOG.info("enter getAreasByCities: {}", location);
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            Element root = XmlUtil.getRootElement(session, "/city.xml");
            List<Element> provinceList = XmlUtil.listNodes(root, location.getProvincePostCode());
            if (!provinceList.isEmpty()) {
                List<Element> cityList = XmlUtil.listNodes(provinceList.get(0), location.getCityPostCode());
                if (!cityList.isEmpty()) {
                    List<Element> areaList = XmlUtil.listNodes(cityList.get(0));
                    mapList = XmlUtil.elementToMap(areaList, "postcode", "name");
                }
            }
            LOG.info("area mapList: {}", mapList);
        } catch (Exception e) {
            LOG.error("getAreasByCity: ", e);
        } finally {
            return mapList;
        }
    }
}
