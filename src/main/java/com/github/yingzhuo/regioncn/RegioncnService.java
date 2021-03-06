/*              _                              _                             _ _            _
 _ __ ___  __ _(_) ___  _ __   ___ _ __       (_) __ ___   ____ _        ___| (_) ___ _ __ | |_
| '__/ _ \/ _` | |/ _ \| '_ \ / __| '_ \ _____| |/ _` \ \ / / _` |_____ / __| | |/ _ \ '_ \| __|
| | |  __/ (_| | | (_) | | | | (__| | | |_____| | (_| |\ V / (_| |_____| (__| | |  __/ | | | |_
|_|  \___|\__, |_|\___/|_| |_|\___|_| |_|    _/ |\__,_| \_/ \__,_|      \___|_|_|\___|_| |_|\__|
          |___/                             |__/

    https://github.com/yingzhuo/regioncn
    https://github.com/yingzhuo/regioncn-java-client
*/
package com.github.yingzhuo.regioncn;

import com.github.yingzhuo.regioncn.model.Area;
import com.github.yingzhuo.regioncn.model.City;
import com.github.yingzhuo.regioncn.model.Province;
import com.github.yingzhuo.regioncn.model.Street;

import java.util.List;

/**
 * @author 应卓
 */
public interface RegioncnService {

    public List<Province> findAllProvince();

    public List<City> findCityByProvinceCode(String provinceCode);

    public List<Area> findAreaByCityCode(String cityCode);

    public List<Street> findStreetByAreaCode(String areaCode);

}
