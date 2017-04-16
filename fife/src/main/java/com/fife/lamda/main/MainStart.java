package com.fife.lamda.main;

import com.fife.lamda.ContenerData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;

/**
 * Created by C5248281 on 4/16/2017.
 */

public class MainStart {

    final private static Logger LOG = LoggerFactory.getLogger(MainStart.class);

    private List<ContenerData> contenerDataList;


    @Before
    public void setUp() {
        contenerDataList = initListContenerData();
    }


    @Test
    public void testMap() {
        List<Integer> listString = contenerDataList.stream().map(ContenerData::getTime).collect(toList());
        assertEquals(asList(1, 2), listString);
    }

    @Test
    public void testFlatMap() {
        List<String> listString = Stream.of(contenerDataList,
                asList(new ContenerData(3, "Get girls")),
                asList(new ContenerData(5, "Get men"), new ContenerData(4, "put 2 women")))
                .flatMap(n -> n.stream()).map(ContenerData::getTimeString)
                .collect(toList());

        assertEquals(asList("First man", "Second woman", "Get girls", "Get men", "put 2 women"), listString);
    }

    @Test
    public void testComparing() {
        List<ContenerData> comparatorList = Stream.of(contenerDataList,
                asList(new ContenerData(3, "Get girls")),
                asList(new ContenerData(5, "Get men"), new ContenerData(4, "put 2 women")))
                .flatMap(n -> n.stream())
                .sorted(Comparator.comparing(ContenerData::getTime))
                .collect(toList());

        List<ContenerData> contenerDataList = getList();
        contenerDataList.sort(Comparator.comparing(ContenerData::getTime));
        LOG.info(comparatorList.toString());
        LOG.info(contenerDataList.toString());
        assertEquals(comparatorList, contenerDataList);
    }

    private List<ContenerData> initListContenerData() {
        return asList(new ContenerData(1, "First man"), new ContenerData(2, "Second woman"));
    }

    private List<ContenerData> getList() {
        return asList(new ContenerData(1, "First man"), new ContenerData(2, "Second woman"),
                new ContenerData(3, "Get girls"),
                new ContenerData(5, "Get men"), new ContenerData(4, "put 2 women"));
    }
}
