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

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @author 应卓
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "regioncn")
public class Props implements Serializable, InitializingBean {

    private boolean enabled = true;
    private Type type = Type.PROTOBUF;
    private String hostname = "localhost";
    private int port = 8080;

    @Override
    public void afterPropertiesSet() {
        Assert.hasText(hostname, "snowflake.hostname is null or empty.");
        Assert.notNull(type, "snowflake.type is null.");
    }

}
