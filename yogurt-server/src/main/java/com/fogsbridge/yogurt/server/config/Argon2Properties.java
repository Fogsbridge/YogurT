package com.fogsbridge.yogurt.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Argon2 密码哈希配置外部化
 *
 * @author fogsbridge
 * @since 1.0.0
 */

@ConfigurationProperties(prefix = "password.encoder.argon2")
public class Argon2Properties {
    private int saltLength = 16;
    private int hashLength = 32;
    private int parallelism = 1;
    private int memory = 16384;
    private int iterations = 4;

    public int getSaltLength() {
        return saltLength;
    }

    public void setSaltLength(int saltLength) {
        this.saltLength = saltLength;
    }

    public int getHashLength() {
        return hashLength;
    }

    public void setHashLength(int hashLength) {
        this.hashLength = hashLength;
    }

    public int getParallelism() {
        return parallelism;
    }

    public void setParallelism(int parallelism) {
        this.parallelism = parallelism;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}
