/*              _                              _                             _ _            _
 _ __ ___  __ _(_) ___  _ __   ___ _ __       (_) __ ___   ____ _        ___| (_) ___ _ __ | |_
| '__/ _ \/ _` | |/ _ \| '_ \ / __| '_ \ _____| |/ _` \ \ / / _` |_____ / __| | |/ _ \ '_ \| __|
| | |  __/ (_| | | (_) | | | | (__| | | |_____| | (_| |\ V / (_| |_____| (__| | |  __/ | | | |_
|_|  \___|\__, |_|\___/|_| |_|\___|_| |_|    _/ |\__,_| \_/ \__,_|      \___|_|_|\___|_| |_|\__|
          |___/                             |__/

    https://github.com/yingzhuo/regioncn
    https://github.com/yingzhuo/regioncn-java-client
*/
package com.github.yingzhuo.regioncn.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 应卓
 */
@Getter
@Setter
@ToString
public abstract class AbstractModel implements Serializable {

    private Long id;
    private String code;
    private String name;
    private String shortName;
    private Double lat;
    private Double lng;

}
