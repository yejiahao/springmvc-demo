package org.yejh.shop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yejh.shop.entity.Location;
import org.yejh.shop.utils.XmlUtil;

/**
 * Created by Ye Jiahao on 2017/03/19.
 */

@Controller
@RequestMapping(value = "/province")
public class ProvinceController {
	private static final Logger logger = LoggerFactory.getLogger(ProvinceController.class);

	@RequestMapping(value = "/getProvinces", method = { RequestMethod.GET })
	@ResponseBody
	public Object getProvinces(HttpSession session) {
		try {
			Element root = XmlUtil.getRootElement(session, "/city.xml");
			List<Map<String, String>> list = XmlUtil.getSubAttr(root, "province");
			return list;
		} catch (Exception e) {
			logger.error("getProvinces: ", e);
		}
		return null;
	}

	@RequestMapping(value = "/getCitiesByProvince", method = { RequestMethod.POST })
	@ResponseBody
	public Object getCitiesByProvince(HttpSession session, @RequestBody Location location) {
		logger.info("enter getCitiesByProvince: {}", location);
		try {
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Element root = XmlUtil.getRootElement(session, "/city.xml");

			Element provinceElement = XmlUtil.getSubElement(root, "province", location.getProvincePostCode());
			if (provinceElement != null) {
				list = XmlUtil.getSubAttr(provinceElement, "city");
			}
			return list;
		} catch (Exception e) {
			logger.error("getCitiesByProvince: ", e);
		}
		return null;
	}

	@RequestMapping(value = "/getAreasByCity", method = { RequestMethod.POST })
	@ResponseBody
	public Object getAreasByCity(HttpSession session, @RequestBody Location location) {
		logger.info("enter getAreasByCities: {}", location);
		try {
			List<Map<String, String>> list = null;
			Element root = XmlUtil.getRootElement(session, "/city.xml");

			Element provinceElement = XmlUtil.getSubElement(root, "province", location.getProvincePostCode());
			if (provinceElement != null) {
				Element cityElement = XmlUtil.getSubElement(provinceElement, "city", location.getCityPostCode());
				if (cityElement != null) {
					list = XmlUtil.getSubAttr(cityElement, "area");
				}
			}
			return list;
		} catch (Exception e) {
			logger.error("getAreasByCity: ", e);
		}
		return null;
	}
}
