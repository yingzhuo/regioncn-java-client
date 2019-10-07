/*              _                              _                             _ _            _
 _ __ ___  __ _(_) ___  _ __   ___ _ __       (_) __ ___   ____ _        ___| (_) ___ _ __ | |_
| '__/ _ \/ _` | |/ _ \| '_ \ / __| '_ \ _____| |/ _` \ \ / / _` |_____ / __| | |/ _ \ '_ \| __|
| | |  __/ (_| | | (_) | | | | (__| | | |_____| | (_| |\ V / (_| |_____| (__| | |  __/ | | | |_
|_|  \___|\__, |_|\___/|_| |_|\___|_| |_|    _/ |\__,_| \_/ \__,_|      \___|_|_|\___|_| |_|\__|
          |___/                             |__/

    https://github.com/yingzhuo/regioncn
    https://github.com/yingzhuo/regioncn-java-client
*/
package com.github.yingzhuo.regioncn.autoconfig;

import com.github.yingzhuo.regioncn.Props;
import com.github.yingzhuo.regioncn.RegioncnService;
import com.github.yingzhuo.regioncn.impl.RegioncnServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author 应卓
 */
@ConditionalOnProperty(prefix = "regioncn", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(Props.class)
public class RegioncnAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public RegioncnService regioncnService(Props props) {
        return new RegioncnServiceImpl(props.getHostname(), props.getPort(), props.getType());
    }

}
