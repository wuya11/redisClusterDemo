/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:  redis cluster 测试
 * Copyright:  2018 CSNT. All rights reserved.
 * Company:CSNT
 *
 * @author wangling
 * @version 1.0
 */
public class RedisClusterTestDemo {
            @Test
           public void testRedisCluster() throws Exception {
                JedisPoolConfig poolConfig = new JedisPoolConfig();
                Set<HostAndPort> nodes = new HashSet<HostAndPort>();
                HostAndPort hostAndPort = new HostAndPort("192.168.210.128", 7000);
                HostAndPort hostAndPort1 = new HostAndPort("192.168.210.128", 7001);
                HostAndPort hostAndPort2 = new HostAndPort("192.168.210.128", 7002);
                HostAndPort hostAndPort3 = new HostAndPort("192.168.210.128", 7003);
                HostAndPort hostAndPort4 = new HostAndPort("192.168.210.128", 7004);
                HostAndPort hostAndPort5 = new HostAndPort("192.168.210.128", 7005);
                nodes.add(hostAndPort);
                nodes.add(hostAndPort1);
                nodes.add(hostAndPort2);
                nodes.add(hostAndPort3);
                nodes.add(hostAndPort4);
                nodes.add(hostAndPort5);
                JedisCluster jedisCluster = new JedisCluster(nodes,5000,1000);
                jedisCluster.set("jedisKey","wangling test jedisKey");
                    //redis内部会创建连接池，从连接池中获取连接使用，然后再把连接返回给连接池
                String string = jedisCluster.get("jedisKey");
                System.out.println(string);
                 }
         }