/*
 * Copyright 2023 VMware, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.core.instrument.binder.netty4;

import io.micrometer.common.docs.KeyName;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.docs.MeterDocumentation;

/**
 * Meter documentation for Netty 4.
 *
 * @author Brian Clozel
 * @since 1.11.0
 * @see NettyAllocatorMetrics
 * @see NettyEventExecutorMetrics
 */
public enum NettyMeters implements MeterDocumentation {

    /**
     * Size of memory used by the allocator, in bytes.
     */
    ALLOCATOR_MEMORY_USED {
        @Override
        public String getName() {
            return "netty.allocator.memory.used";
        }

        @Override
        public Meter.Type getType() {
            return Meter.Type.GAUGE;
        }

        @Override
        public String getBaseUnit() {
            return "bytes";
        }

        @Override
        public KeyName[] getKeyNames() {
            return KeyName.merge(AllocatorMeterTags.values(), AllocatorMemoryMeterTags.values());
        }
    },

    /**
     * Size of memory used by allocated buffers, in bytes.
     */
    ALLOCATOR_MEMORY_PINNED {
        @Override
        public String getName() {
            return "netty.allocator.memory.pinned";
        }

        @Override
        public Meter.Type getType() {
            return Meter.Type.GAUGE;
        }

        @Override
        public String getBaseUnit() {
            return "bytes";
        }

        @Override
        public KeyName[] getKeyNames() {
            return KeyName.merge(AllocatorMeterTags.values(), AllocatorMemoryMeterTags.values());
        }
    },

    /**
     * Number of Arenas for a pooled allocator.
     */
    ALLOCATOR_POOLED_ARENAS {
        @Override
        public String getName() {
            return "netty.allocator.pooled.arenas";
        }

        @Override
        public Meter.Type getType() {
            return Meter.Type.GAUGE;
        }

        @Override
        public KeyName[] getKeyNames() {
            return KeyName.merge(AllocatorMeterTags.values(), AllocatorMemoryMeterTags.values());
        }
    },

    /**
     * Size of the cache for a pooled allocator, in bytes.
     */
    ALLOCATOR_POOLED_CACHE_SIZE {
        @Override
        public String getName() {
            return "netty.allocator.pooled.cache.size";
        }

        @Override
        public Meter.Type getType() {
            return Meter.Type.GAUGE;
        }

        @Override
        public String getBaseUnit() {
            return "bytes";
        }

        @Override
        public KeyName[] getKeyNames() {
            return KeyName.merge(AllocatorMeterTags.values(), AllocatorPooledCacheMeterTags.values());
        }
    },

    /**
     * Number of ThreadLocal caches for a pooled allocator.
     */
    ALLOCATOR_POOLED_THREADLOCAL_CACHES {
        @Override
        public String getName() {
            return "netty.allocator.pooled.threadlocal.caches";
        }

        @Override
        public Meter.Type getType() {
            return Meter.Type.GAUGE;
        }

        @Override
        public KeyName[] getKeyNames() {
            return AllocatorMeterTags.values();
        }
    },

    /**
     * Size of memory chunks for a pooled allocator, in bytes.
     */
    ALLOCATOR_POOLED_CHUNK_SIZE {
        @Override
        public String getName() {
            return "netty.allocator.pooled.chunk.size";
        }

        @Override
        public Meter.Type getType() {
            return Meter.Type.GAUGE;
        }

        @Override
        public String getBaseUnit() {
            return "bytes";
        }

        @Override
        public KeyName[] getKeyNames() {
            return AllocatorMeterTags.values();
        }
    },

    /**
     * Number of pending tasks in the event executor.
     */
    EVENT_EXECUTOR_TASKS_PENDING {
        @Override
        public String getName() {
            return "netty.eventexecutor.tasks.pending";
        }

        @Override
        public Meter.Type getType() {
            return Meter.Type.GAUGE;
        }

        @Override
        public KeyName[] getKeyNames() {
            return EventLoopTasksPendingMeterTags.values();
        }
    };

    public enum AllocatorMeterTags implements KeyName {

        /**
         * Unique runtime identifier for the allocator.
         */
        ID {
            @Override
            public String asString() {
                return "id";
            }
        },
        /**
         * Type of memory allocation strategy (pooled, unpooled).
         */
        ALLOCATOR_TYPE {
            @Override
            public String asString() {
                return "allocator.type";
            }
        }

    }

    public enum AllocatorMemoryMeterTags implements KeyName {

        /**
         * Type of memory allocated: {@code "heap"} memory or {@code "direct"} memory.
         */
        MEMORY_TYPE {
            @Override
            public String asString() {
                return "memory.type";
            }
        }

    }

    public enum AllocatorPooledCacheMeterTags implements KeyName {

        /**
         * Type of cache pages for this cache.
         */
        CACHE_TYPE {
            @Override
            public String asString() {
                return "cache.type";
            }
        }

    }

    public enum EventLoopTasksPendingMeterTags implements KeyName {

        /**
         * Event Loop name.
         */
        NAME {
            @Override
            public String asString() {
                return "name";
            }
        }

    }

}
