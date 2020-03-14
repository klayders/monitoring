package org.orglot.admin.monitoring.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.orglot.admin.monitoring.test.model.TestPojo;

import java.util.concurrent.TimeUnit;

public class TestBench {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Gson gson = new GsonBuilder().create();

    private static final String dom2MenuData = "{\n" +
            "    \"menuData\": {\n" +
            "        \"news\": [\n" +
            "            1584194400000,\n" +
            "            1584183600000,\n" +
            "            1584176400000,\n" +
            "            1584111600000,\n" +
            "            1584100800000,\n" +
            "            1584097200000,\n" +
            "            1584093600000,\n" +
            "            1584088200000,\n" +
            "            1584025200000,\n" +
            "            1584018000000\n" +
            "        ],\n" +
            "        \"efir\": [\n" +
            "            1584199569592,\n" +
            "            1584194589663,\n" +
            "            1584169211489,\n" +
            "            1584166029156,\n" +
            "            1584111968645,\n" +
            "            1584108249782,\n" +
            "            1584070216562,\n" +
            "            1584062112630,\n" +
            "            1584057612517,\n" +
            "            1584025568918\n" +
            "        ],\n" +
            "        \"magazine\": [\n" +
            "            1582664400000,\n" +
            "            1580158800000,\n" +
            "            1577134800000,\n" +
            "            1574629200000,\n" +
            "            1572037200000,\n" +
            "            1569272400000,\n" +
            "            1566853200000,\n" +
            "            1563829200000,\n" +
            "            1561323600000,\n" +
            "            1558990800000\n" +
            "        ]\n" +
            "    }\n" +
            "}";

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

//    @Benchmark
//    @Fork(value = 1, warmups = 2)
//    @BenchmarkMode(Mode.Throughput)

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void readValueAsJson() {
        try {
            var menuData = mapper.readValue(dom2MenuData, TestPojo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    @Benchmark
    @Fork(value = 1, warmups = 2)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void readValueAsGson() {
        var menuData = gson.fromJson(dom2MenuData, TestPojo.class);
    }
}
