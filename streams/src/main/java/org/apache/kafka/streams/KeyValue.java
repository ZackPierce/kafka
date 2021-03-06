/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.kafka.streams;

import java.util.Objects;

/**
 * A key-value pair defined for a single Kafka Streams record.
 * If the record comes directly from a Kafka topic then its
 * key / value are defined as the message key / value.
 *
 * @param <K> Key type
 * @param <V> Value type
 */
public class KeyValue<K, V> {

    public final K key;
    public final V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static <K, V> KeyValue<K, V> pair(K key, V value) {
        return new KeyValue<>(key, value);
    }

    public String toString() {
        return "KeyValue(" + key + ", " + value + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (other instanceof KeyValue) {
            KeyValue otherKV = (KeyValue) other;

            return key == null ? otherKV.key == null : key.equals(otherKV.key)
                    && value == null ? otherKV.value == null : value.equals(otherKV.value);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
