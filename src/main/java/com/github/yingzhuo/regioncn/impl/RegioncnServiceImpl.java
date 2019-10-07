/*              _                              _                             _ _            _
 _ __ ___  __ _(_) ___  _ __   ___ _ __       (_) __ ___   ____ _        ___| (_) ___ _ __ | |_
| '__/ _ \/ _` | |/ _ \| '_ \ / __| '_ \ _____| |/ _` \ \ / / _` |_____ / __| | |/ _ \ '_ \| __|
| | |  __/ (_| | | (_) | | | | (__| | | |_____| | (_| |\ V / (_| |_____| (__| | |  __/ | | | |_
|_|  \___|\__, |_|\___/|_| |_|\___|_| |_|    _/ |\__,_| \_/ \__,_|      \___|_|_|\___|_| |_|\__|
          |___/                             |__/

    https://github.com/yingzhuo/regioncn
    https://github.com/yingzhuo/regioncn-java-client
*/
package com.github.yingzhuo.regioncn.impl;

import com.github.yingzhuo.regioncn.RegioncnService;
import com.github.yingzhuo.regioncn.Type;
import com.github.yingzhuo.regioncn.model.Area;
import com.github.yingzhuo.regioncn.model.City;
import com.github.yingzhuo.regioncn.model.Province;
import com.github.yingzhuo.regioncn.model.Street;
import com.github.yingzhuo.regioncn.proto.Proto;
import lombok.val;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 应卓
 */
public class RegioncnServiceImpl implements RegioncnService {

    private static final RestTemplate JSON_REST_TEMPLATE = new RestTemplate(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
    private static final RestTemplate PROTOBUF_REST_TEMPLATE = new RestTemplate(Collections.singletonList(new ProtobufJsonFormatHttpMessageConverter()));

    private final String host;
    private final int port;
    private final Type type;

    public RegioncnServiceImpl(String host, int port, Type type) {
        this.host = host;
        this.port = port;
        this.type = type;
    }

    @Override
    public List<Province> findAllProvince() {
        val url = String.format("http://%s:%d/province", this.host, this.port);

        if (type == Type.PROTOBUF) {
            val xs = PROTOBUF_REST_TEMPLATE.getForEntity(url, Proto.Models.class).getBody();

            if (xs == null || xs.getListList() == null) {
                return new ArrayList<>();
            }

            return xs.getListList().stream().map(m -> {
                val p = new Province();
                p.setId(m.getId());
                p.setCode(m.getCode());
                p.setName(m.getName());
                p.setShortName(m.getShortName());
                p.setLat(m.getLat());
                p.setLng(m.getLng());
                return p;
            }).collect(Collectors.toList());
        } else {
            return JSON_REST_TEMPLATE.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Province>>() {
            }).getBody();
        }
    }

    @Override
    public List<City> findCityByProvinceCode(String provinceCode) {
        val url = String.format("http://%s:%d/city?provinceCode={provinceCode}", this.host, this.port);

        if (type == Type.PROTOBUF) {
            val xs = PROTOBUF_REST_TEMPLATE.getForEntity(url, Proto.Models.class, provinceCode).getBody();
            if (xs == null || xs.getListList() == null) {
                return new ArrayList<>();
            }

            return xs.getListList().stream().map(m -> {
                val p = new City();
                p.setId(m.getId());
                p.setCode(m.getCode());
                p.setName(m.getName());
                p.setShortName(m.getShortName());
                p.setLat(m.getLat());
                p.setLng(m.getLng());
                return p;
            }).collect(Collectors.toList());
        } else {
            val result = JSON_REST_TEMPLATE.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<City>>() {
            }, provinceCode).getBody();

            return result != null ? result : new ArrayList<>();
        }
    }

    @Override
    public List<Area> findAreaByCityCode(String cityCode) {
        val url = String.format("http://%s:%d/area?cityCode={cityCode}", this.host, this.port);

        if (type == Type.PROTOBUF) {
            val xs = PROTOBUF_REST_TEMPLATE.getForEntity(url, Proto.Models.class, cityCode).getBody();
            if (xs == null || xs.getListList() == null) {
                return new ArrayList<>();
            }

            return xs.getListList().stream().map(m -> {
                val p = new Area();
                p.setId(m.getId());
                p.setCode(m.getCode());
                p.setName(m.getName());
                p.setShortName(m.getShortName());
                p.setLat(m.getLat());
                p.setLng(m.getLng());
                return p;
            }).collect(Collectors.toList());
        } else {
            val result = JSON_REST_TEMPLATE.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Area>>() {
            }, cityCode).getBody();

            return result != null ? result : new ArrayList<>();
        }
    }

    @Override
    public List<Street> findStreetByAreaCode(String areaCode) {
        val url = String.format("http://%s:%d/street?areaCode={areaCode}", this.host, this.port);

        if (type == Type.PROTOBUF) {
            val xs = PROTOBUF_REST_TEMPLATE.getForEntity(url, Proto.Models.class, areaCode).getBody();
            if (xs == null || xs.getListList() == null) {
                return new ArrayList<>();
            }

            return xs.getListList().stream().map(m -> {
                val p = new Street();
                p.setId(m.getId());
                p.setCode(m.getCode());
                p.setName(m.getName());
                p.setShortName(m.getShortName());
                p.setLat(m.getLat());
                p.setLng(m.getLng());
                return p;
            }).collect(Collectors.toList());
        } else {
            val result = JSON_REST_TEMPLATE.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Street>>() {
            }, areaCode).getBody();

            return result != null ? result : new ArrayList<>();
        }
    }

}
